/*
Question:
========
    the function stringToDecimal must return an Integer X whose 
	binary representation is formed by replacing each 
	odd Ascii alphabet wiht 1 and each even ascii alphabet with 0, in the given string
 



IMPORTANT: 
========
Do not write the main() function as it is already defined.

 Boundary Condition(s):
=============== 
1 <= Length of the string str <= 50 

Example Input/Output 1:
================

 Input:
=====
 Moon 
 
 Output:
======
 14

 Explanation:
=========
 The ASCII value of M is 77.
 The ASCII value of o is 111.
 The ASCII value of n is 110. 
 So Moon -> 1110 -> 14. 
 
 Example 
 =======
Input/Output 2: 
==========

Input: 
====
SouthIndia 

Output:
======
 915 
 
 Max Execution Time Limit: 50 millisecs
 
 */
 
 
long long int stringToDecimal(char *str)
{
    
    long long int ans=0;
    int len = strlen(str);
    for(int i=0;i<len;i++)
    {
        ans=ans+ pow(2,len-i-1)*(str[i]%2);
        //printf("%lld\n",ans);
    }
    return ans;
}