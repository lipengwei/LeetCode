package AlgorithmPractice;

import java.util.Stack;

/*
 * 统计方法
 * 计算一个数组中的大多数  必须大于 n/2 才能用
 */
public class Anagram {

	public static void main(String[] args) {
		int [] a = {1,2,3,4,5,6,7,7,8,9,10,3,4,3,5,6,11,15};
//		majority(a);
		int count = 0;
		int t = 0;
		for(int i=0;i<a.length;i++){
			if(count == 0){
				t = a[i];
				count++;
			}else if(t == a[i]){
				count++;
			}else{
				count--;
			}
		}
		System.out.println(t);
	}

	public static void majority(int[] nums){
		int cand = nums[0];
		int count = 0;
		for(int i = 0;i<nums.length;i++){
			if(count == 0){
				cand = nums[i];
				count++;
			}else if(cand == nums[i]){
				count++;
			}else{
				count--;
			}
		}
		System.out.println(cand);
	}
}
