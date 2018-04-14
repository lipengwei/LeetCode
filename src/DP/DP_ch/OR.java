package DP.DP_ch;

import java.util.ArrayList;
import java.util.List;

public class OR {

	public static void main(String[] args) {
		int [] a = {4,3,2,7,8,2,3,1};
//		System.out.println(findDisappearedNumbers(a));
		System.out.println(findDisappearedNumbers1(a));

	}
	
	public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> li = new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++){
        	if(nums[Math.abs(nums[i]) - 1] > 0){
        		nums[Math.abs(nums[i]) - 1] = 0 - nums[Math.abs(nums[i]) - 1];
        	}
        }
        for(int i=0;i<nums.length;i++){
        	if(nums[i] > 0){
        		li.add(i+1);
        	}
        }
        return li;
    }
	
	public static List<Integer> findDisappearedNumbers1(int[] nums) {
		int [] visited = new int[nums.length];
        List<Integer> li = new ArrayList<Integer>();
        for(int i = 0;i<nums.length;i++){
        	visited[nums[i] - 1] = 1;
        }
        
        for(int i = 0;i<nums.length;i++){
        	if(visited[i] == 0){
        		li.add(i+1);
        	}
        }
        return li;
    }
}
