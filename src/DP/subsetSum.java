package DP;
/*
 * 子集和问题  回溯法，所有子集和为固定值的 列表
 */
import java.util.ArrayList;

public class subsetSum {
	public static ArrayList<Integer> list = new ArrayList<Integer>();
	
	public static int getSum(ArrayList<Integer> list){
		int sum = 0;
		for(int i=0;i<list.size();i++){
			sum += list.get(i);
		}
		return sum;
	}
	
	public static int getSum_1(int [] a, int low, int high){
		int sum = 0;
		for(int i=low;i<high-low +1 && low < high;i++){
			sum += a[i];
		}
		return sum;
	}
	
	public static void getSubset(int [] A, int m, int index){
		while(index < A.length){
			list.add(A[index]);
			if(getSum(list) == m){
				System.out.println(list);
			}
			index++;
			getSubset(A, m, index);
			list.remove(list.size() - 1);
		}
	}
	
	public static int getSum1(boolean[] visited,int []a){
		int sum = 0;
		for(int i=0;i<a.length;i++){
			if(visited[i]){
				sum+=a[i];
			}
		}
		return sum;
	}
	public static void getSubset2(boolean[] visited,int[] a,int m,int step){
		if(step == a.length){
			if(getSum1(visited, a) == m){
				for(int i=0;i<a.length;i++){
					if(visited[i]){
						System.out.print(a[i] + " ");
					}
				}
				System.out.println();
			}
			return;
		}
		visited[step] = true;
		getSubset2(visited,a,m,step+1);
		visited[step] = false;
		getSubset2(visited,a,m,step+1);
	}
	
	public static ArrayList<ArrayList<Integer>> getSubsetSumDP(int sum){
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		if(sum <=1) return result;
		int start = 1;
		int end = 2;
		int middle = (1+sum)/2;
		int tmp = start + end;
		list.add(start);
		list.add(end);
		
		while(start < middle){
			if(tmp == sum){
				result.add(new ArrayList<Integer>(list));
				end++;
				tmp += end;
				list.add(end);
			}else if(tmp < sum){
				end++;
				tmp += end;
				list.add(end);
			}else{
				tmp -= start;
				list.remove(new Integer(start));
				start++;
			}
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6};
		boolean [] visited = {false,false,false,false,false,false};
//		getSubset(a, 5, 0);
//		getSubsetSumDP(a,5);
//		ArrayList<ArrayList<Integer>> list = getSubsetSumDP(100);
		getSubset2(visited, a, 8, 0);
//		ArrayList<Integer> list = getSubsetDP(a,6);
//		System.out.println(list);
//		for(int i=0;i<list.size();i++){
//			System.out.print(list.get(i));
//		}
	}
	
	public static ArrayList<Integer> getSubsetDP(int[] array, int k){
		int start = 0;
		int sum = 0;
		list.add(array[start]);
		for(int i=0;i<array.length;i++){
			sum += array[i];
			if(sum == k){
				list.add(array[i]);
				System.out.println(list);
			}else if(sum > k){
				
			}
		}
		
		
		 return list;
	}
	
	public static void DFS(int [] a, int v, ArrayList<Integer> list,int k){
		list.add(a[v]);
		if(getSum(list) == k){
			System.out.println(list);
		}else if(getSum(list) > k){
			list.remove(list.size() - 1);
			for(;v<a.length;v++){
				if(!list.contains(a[v])){
					DFS(a,v,list,k);
				}
			}
		}else{
			
		}
		
	}

}
