package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController 
{
	@Autowired
	private UserDao userdao;
	
	@RequestMapping("/")
	public String hi()
	{
		return "index.jsp";
	}
	@RequestMapping("/adduser")
	public String add(Users user)
	{
		userdao.save(user);
		return "index.jsp";
	}
	
	@RequestMapping("/getuser")
	public String getuser()
	{
		return "getuser.jsp";
	}
	
	@RequestMapping("/showuser")
	public ModelAndView get(@RequestParam long Aadhar_id)
	{
		ModelAndView mav = new ModelAndView("showuser.jsp");
		Users Hello =  userdao.findById(Aadhar_id).orElse(new Users(Aadhar_id,"null","null"));
		//Users user =  userdao.getById(id)
		mav.addObject("Hello",Hello);
		System.out.println(Hello);
		return mav;
	}
}
