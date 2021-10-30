import java.util.*;
public class Hello {

    public static void main(String[] args) {
		//Your Code Here
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt(),n  = sc.nextInt(),r=m*n,c=m*n,val=0;
		int[][] mat = new int[r][c];
		for(int i=0;i<r;i+=m)
		{
		    for(int j=0;j<c;j+=m)
		    {
		        int start=(++val);
		        for(int i1=i;i1<i+m;i1++)
		        {
		            for(int j1=j;j1<j+m;j1++)
		            {
		                mat[i1][j1] = start;
		                start++;
		            }
		        }
		        print(mat);
		        System.out.println();
		    }
		}
		print(mat);
	}
	static void print(int[][] mat)
	{
	    for(int i=0;i<mat.length;i++)
	    {
	        for(int j=0;j<mat[i].length;j++)
	            System.out.print(mat[i][j]+" ");
	        System.out.println();
	    }
	}
}
