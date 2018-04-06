package DP;

import java.util.HashMap;
import java.util.Map;
/*
 * 0-1±³°üÎÊÌâ
 */
public class Knapsack {

	public static void main(String[] args) {
//		int[] v = {0,3,4,5,8,10};
//		int[] w = {0,2,3,4,5,9};
//		int[][] kp = new int[6][21];
//		Knapsack(v,w,kp);
		int hm = 5;
		System.out.println(--hm);
	}
	
	public static void Knapsack(int[] v,int[] w, int[][] kp){
		for(int i=1;i< 6;i++){
			for(int j=1;j<21;j++){
				if(w[i] > j){
					kp[i][j] = kp[i-1][j]; 
				}else{
					kp[i][j] = Math.max(kp[i-1][j], kp[i-1][j-w[i]] + v[i]);
				}
			}
		}
		System.out.println(kp[5][20]);
	}

}
