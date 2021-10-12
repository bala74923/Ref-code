// Find Positions of Substrings

import java.util.*;
public class Hello {

    public static void main(String[] args) {
		//Your Code Here
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String first_sub = sc.next();
		int sub_length = first_sub.length();
		int total_subs = s.length()/sub_length;
	    Map<String,Integer> map = getmap(s,sub_length,total_subs);
	    System.out.println(map.get(first_sub));
	    while(sc.hasNext())
	    {
	        System.out.println(map.get(sc.next()));
	    }
	}
	static Map<String,Integer> getmap(String s,int sub_len,int total)
	{
	    int ind=0;
	    Map<String,Integer> map = new TreeMap<>();
	    for(int i=0;i<s.length();i+=sub_len)
	    {
	       map.put(s.substring(i,i+sub_len),++ind);
	    }
	    return map;
	}
}