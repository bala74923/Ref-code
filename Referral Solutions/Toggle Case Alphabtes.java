/******************************************************************************
Toggle Case Alphabets
=======================

Input:
=======
breadANDjam

Output:
=======
BREADandJAM

Input:
=======
SKILLrack

Output:
=======
skillRACK

*******************************************************************************/
import java.util.*;
public class Main {

    public static void main(String[] args) {
		//Your Code Here
		Scanner sc = new Scanner(System.in);
		String s = sc.next(),ans="",temp="";
		int i=0;
		while(i<s.length())
		{
		    temp+=s.charAt(i);
		    if(i==s.length()-1|| !isSameCase(s.charAt(i),s.charAt(i+1)))
		    {
		        ans+= (temp.length()>=2)?changeCase(temp):temp;	
		        //System.out.println(temp);
		        temp="";
		      }
		    i++;
		}
		System.out.println(ans);
	}
	static boolean isSameCase(char ch1,char ch2)
	{
	    return ((ch1>96 && ch2>96) || (ch1<96 && ch2<96))?true:false;
	}
	static String changeCase(String temp)
	{return 96<temp.charAt(0)?temp.toUpperCase():temp.toLowerCase();}
}
