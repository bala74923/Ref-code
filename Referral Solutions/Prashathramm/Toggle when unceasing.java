import java.util.*;
public class Hello {

    public static void main(String[] args) {
		//Your Code Here
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		s+=Character.isLowerCase(s.charAt(s.length()-1))?"A":"a";
		int f=Character.isLowerCase(s.charAt(0))?0:1;
        	String str="";
		for(int i=0;i<s.length();++i)
		{
		    char ch=s.charAt(i);
		    if(ch>='a' && ch<='z') 
		    {
		        if(!str.isEmpty() && f==1) 
		        {
		            System.out.print(str.length()>1?str.toLowerCase():str);
		            f=0;
		            str="";
		        }
		        str+=ch;
		    }
		    else if(ch>='A' && ch<='Z')
		    {
		        if(!str.isEmpty() && f==0) 
		        {
		            System.out.print(str.length()>1?str.toUpperCase():str);
		            f=1;
		            str="";
		        }
		        str+=ch;
		    }
	    	}
	}
}