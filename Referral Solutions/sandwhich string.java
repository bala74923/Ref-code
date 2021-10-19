import java.util.*;
public class Hello {

    public static void main(String[] args) {
		//Your Code Here
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		System.out.println(check(s)?"YES":"NO");
	}
	static boolean check(String s)
	{
	    int lo =  0,hi = s.length()-1;
	    char c = s.charAt(0);
	    while(lo<hi && s.charAt(lo)==c && s.charAt(hi)==c)
	    {
	        lo++;
	        hi--;
	    }
	    if(lo==0) return false;
	    String mid = s.substring(lo,hi+1);
	    String curr = (""+s.charAt(lo)).repeat(hi-lo+1);
	    //System.out.println(mid+"\n"+curr);
	    return mid.equals(curr) && count(s)==2;
	}
	static int count(String s)
	{
	    Map<Character,Integer> map = new HashMap<>();
	    for(int i=0;i<s.length();i++)
	        map.put(s.charAt(i),1);
	    return map.size();
	}
}