package AlgorithmPractice;

import java.util.ArrayList;
import java.util.List;
/*
 * 全排列   递归实现
 * 1 + 【后面的全排列】
 * 递归的实现这个过程
 * 递归出口就是 这个数组只剩下最后一个元素
 */
public class Permutation {

	public static void main(String[] args) {
		int [] a = {1, 2, 3};
		List<List<Integer>> list = permute(a);
		System.out.println(list);
	}
	
	public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        perm(nums, 0, nums.length-1, list);
        return list;
    }
	
	public static void perm(int[] a, int l, int r, List<List<Integer>> list){
		if(l == r){
			List<Integer> li = SetList(a);
			list.add(li);
		}else{
			for(int i=l;i<=r;i++){
				swap(a, l, i);
				perm(a, l+1, r, list);
				swap(a, l, i);
			}
		}
	}
	
	public static void swap(int[] a, int l, int r){
		int temp = a[l];
		a[l] = a[r];
		a[r] = temp;
	}
	
	public static List<Integer> SetList(int [] a){
		List<Integer> li = new ArrayList<Integer>();
		for(int i=0;i<a.length;i++){
			li.add(a[i]);
		}
		return li;
	}
}
