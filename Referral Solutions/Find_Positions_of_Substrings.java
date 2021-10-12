// Find Positions of Substrings

import java.util.*;
public class Main {

    public static void main(String[] args) {
		//Your Code Here
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String first_subString = sc.next();
		int substring_length = first_subString.length();
		int total_no_of subs = s.length()/substring_length;
	    Map<String,Integer> result = getresult(s,substring_length,total_no_of subs);
	    System.out.println(result.get(first_subString));
	    while(sc.hasNext())
	    {
	        System.out.println(result.get(sc.next()));
	    }
	}
	static Map<String,Integer> getresult(String s,int sub_len,int total)
	{
	    int ind=0;
	    Map<String,Integer> result = new TreeMap<>();
	    for(int i=0;i<s.length();i+=sub_len) 
            result.put(s.substring(i,i+sub_len),++ind);
	    return result;
	}
}