/*INPUT:
6

//OUTPUT:
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
0*/

//CODE
import java.util.*;
public class Hello {

    public static void main(String[] args) {
		//Your Code Here
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		String[] arr=new String[n];
		arr[0]="0"; arr[1]="1";
		for(int i=2;i<n;++i) arr[i]=arr[i-2]+arr[i-1];
	        for(int i=0;i<2*n-1;i++) System.out.println(i<n?arr[i]:arr[n-(i%n)-2]);
	}
}
