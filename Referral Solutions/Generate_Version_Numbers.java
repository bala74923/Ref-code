// Generate Version Numbers
/*
input:
=======
a b
1 2

output:
========
a1.a.1
a1.a.2
a1.b.1
a1.b.2
a2.a.1
a2.a.2
a2.b.1
a2.b.2
b1.a.1
b1.a.2
b1.b.1
b1.b.2
b2.a.1
b2.a.2
b2.b.1
b2.b.2






input :
=======
x y
7 9

output:
========
x7.x.7
x7.x.8
x7.x.9
x7.y.7
x7.y.8
x7.y.9
x8.x.7
x8.x.8
x8.x.9
x8.y.7
x8.y.8
x8.y.9
x9.x.7
x9.x.8
x9.x.9
x9.y.7
x9.y.8
x9.y.9
y7.x.7
y7.x.8
y7.x.9
y7.y.7
y7.y.8
y7.y.9
y8.x.7
y8.x.8
y8.x.9
y8.y.7
y8.y.8
y8.y.9
y9.x.7
y9.x.8
y9.x.9
y9.y.7
y9.y.8
y9.y.9
*/

import java.util.*;
public class Main {

    public static void main(String[] args) {
		//Your Code Here
		Scanner sc = new Scanner(System.in);
		char start_char = sc.next().charAt(0),end_char=sc.next().charAt(0);
		int x = sc.nextInt(),y = sc.nextInt();
		for(int i=start_char;i<=end_char;i++)
		{
		    for(int j=x;j<=y;j++)
		    {
		        printAllCombinations((char)i,j,start_char,end_char,x,y);
		    }
		}
	}
	static void printAllCombinations(char s,int n,int start_char,int end_char,int x,int y)
	{
	    for(int i=start_char;i<=end_char;i++)
	    {
	        for(int j=x;j<=y;j++)
	        {
	            System.out.println(""+s+n+"."+((char)i)+"."+j);
	        }
	    }
	}
}