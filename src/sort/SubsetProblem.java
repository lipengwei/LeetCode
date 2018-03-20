package sort;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/*
 * 子数组的问题   子序列
 * 子集的问题   
 */
public class SubsetProblem {

	public static void main(String[] args) {
		int [] a = {3,5,6,8,9,12,56,98,112};
//		System.out.println(SubArea(a));
		System.out.println(subsets(a));
	}
	
	public static int SubArea(int [] a){
		int max = 0;
		Stack<Integer> st = new Stack<Integer>();
		for(int i=0;i<a.length;i++){
			while(!st.isEmpty() && a[i] <= a[st.peek()]){
				int pop_index = st.pop();
				int left_index = st.isEmpty()?-1:st.peek();
				max = (max > (i - left_index - 1)*a[pop_index])?max:(i - left_index - 1)*a[pop_index];
			}
			st.push(i);
		}
		while(!st.isEmpty()){
			int pop_index = st.pop();
			int left_index = st.isEmpty()?-1:st.peek();
			max = (max > (a.length - left_index -1)*a[pop_index])?max:(a.length - left_index -1)*a[pop_index];
		}
		return max;
	}
	
	public static List<List<Integer>> subsets(int[] a){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(a.length == 0){
			return result;
		}
//		Arrays.sort(a);
		dfs(a,0,new ArrayList<Integer>(), result);
		return result;
	}
	
	public static void dfs(int[] a,int index,List<Integer> path,List<List<Integer>> result){
		result.add(new ArrayList<Integer>(path));
		
		for(int i=index;i<a.length;i++){
			path.add(a[i]);
			dfs(a,i+1,path,result);
			path.remove(path.size() - 1);
		}
	}
}
