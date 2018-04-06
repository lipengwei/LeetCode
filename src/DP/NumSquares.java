package DP;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
 * leetcode 279
 * 方法一，广度优先遍历  -- 层次遍历
 */
public class NumSquares {

	public static void main(String[] args) {
		System.out.println(numSquares1(9));
	}
	
	public static int numSquares1(int n){
		int [] dp = new int[n+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for(int i=0;i<=n;i++){
//			for(int j=1;i+j*j<=n;j++){
			for(int j=1;j*j<=i;j++){
//				dp[i+j*j] = Math.min(dp[i+j*j], dp[i]+1);
				dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
			}
		}
		return dp[n];
	}

	
	public static int numSquares(int n) {
		Queue<int[]> q = new LinkedList<int[]>();
		boolean[] visited = new boolean[n+1];
		int [] a = {n,0};
		q.offer(a);
		visited[n] = true;
		
		while(!q.isEmpty()){
			int num = q.peek()[0];
			int step = q.peek()[1];
			q.poll();
			
			if( num == 0){
				return step;
			}
			
			for(int i=1;;i++){
				int at = num -i*i;
				if(at < 0){
					break;
				}
				if(at >= 0){
					int [] temp = {at, step+1};
					if(!visited[at]){
						q.offer(temp);
						visited[at] = true;
					}
				}
	        }
		}
		return -1;
    }
}
