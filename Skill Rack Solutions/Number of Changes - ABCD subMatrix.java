import java.util.*;
public class Hello {

    public static void main(String[] args) {
		//Your Code Here
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt(),c = sc.nextInt();
		char[][] arr = new char[r][c];
		for(int i=0;i<r;i++)
		{
		    for(int j=0;j<c;j++) arr[i][j]=sc.next().charAt(0);
		}
		char[][] abcd = {{'A','B'},{'C','D'}};
		int ans=0;
		for(int i=0;i<r;i+=2)
		{
		    for(int j=0;j<c;j+=2)
		    {
		        //2*2 matrix
		       int currRow=0;
		        for(int h=i;h<i+2;h++)
		        {
		            int currCol=0;
		            for(int k=j;k<j+2;k++)
		            {
		                ans+= abcd[currRow][currCol]==arr[h][k]?0:1;
		                currCol++;
		            }
		            currRow++;
		        }
		    }
		}
		System.out.println(ans);
	}
}