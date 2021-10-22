import java.util.*;
public class Hello {

    public static void main(String[] args) {
		//Your Code Here
		Scanner sc=new Scanner(System.in);
		int r=sc.nextInt(),c=sc.nextInt(),ctr=0;
		char[][] m=new char[r][c];
		for(int i=0;i<r;++i)
		{
		    for(int j=0;j<c;++j)
		    {
		        m[i][j]=sc.next().charAt(0);
		    }
		}
		for(int i=0;i<r;i+=2)
		{
		    for(int j=0;j<c;j+=2)
		    {
		        if(m[i][j]!='A') ctr++; 
		        if(m[i][j+1]!='B') ctr++;
		        if(m[i+1][j]!='C') ctr++;
		        if(m[i+1][j+1]!='D') ctr++;
		    }
		}
		System.out.print(ctr);
    }
}
Java 