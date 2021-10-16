import java.util.*;
public class Permutations {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4};
		List<Integer> list = new ArrayList<>();
		for(int n:arr) list.add(n);
		List<List<Integer>> soln = new ArrayList<>();
		permutate(soln,list,0,arr.length-1);
		System.out.println(soln);
	}
	static void permutate(List<List<Integer>> soln,List<Integer> list,int lo,int hi)
	{
		if(lo==hi)
		{
			soln.add(new ArrayList<Integer>(list));
			return ;
		}
		for(int i=lo;i<=hi;i++)
		{
			swap(list,i,lo);
			permutate(soln,new ArrayList<Integer>(list), lo+1, hi);
			swap(list,i,lo);
		}
	} 
	static void swap(List<Integer> list,int i,int j)
	{
		int temp = list.get(i);
		list.set(i,list.get(j));
		list.set(j,temp);
	}
}