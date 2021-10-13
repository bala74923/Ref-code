// Binary_Fibonacci_Pattern
/*
Input:
=========
6

Output:
====================
0
1
01
101
01101
10101101
01101
101
01
1
0

*/

import java.util.*;
public class Main {

    public static void main(String[] args) {
		//Your Code Here
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		String[] arr = new String[n];
		for(int i=0;i<n;i++) 
		   {
		       if(i<2) arr[i]=i+"";
		       else arr[i]=arr[i-2]+arr[i-1];
		   }
		print(arr,0,n-1,1);
		print(arr,n-1,-1,-1);
	}
	static void print(String[] arr,int start,int end,int itr)
	{
	    for(int i=start;i!=end;i+=itr)
	        System.out.println(arr[i]);
	}
}