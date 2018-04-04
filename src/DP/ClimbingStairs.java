package DP;

import java.util.ArrayList;
import java.util.List;

/*
 * leetcode 70  爬楼梯
 */
public class ClimbingStairs {
	
	public static void main(String[] args) {
		int n = 44;
		int [] memo = new int[n+1];
		for(int i=0;i<n+1;i++){
			memo[i] = -1;
		}
		int count = Method(n,memo);
		System.out.println(count);
	}
	public static int climbStairs(int n) {
		int [] memo = new int[n+1];
		for(int i=0;i<n+1;i++){
			memo[i] = -1;
		}
        return Method(n,memo) + Method(n,memo);
    }
	// 递归的方式
	public static int Method(int n, int [] memo){
		if(n  == 1 || n  == 0){
			return 1;
		}else{
			if(memo[n] == -1){
				memo[n] = Method(n-1,memo) + Method(n-2,memo);
			}
			return (memo[n]); 
		}
	}
	
	// 动态规划
	public static int Method1(){
		return 0;
	}
}
