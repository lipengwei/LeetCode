package DP;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class Machine {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //机器
		int M = sc.nextInt(); //任务
		
		int[] a = new int[M];
		int[] b = new int[M];
		
		int[] c = new int[N];
		int[] d = new int[N];
		
		Map<Integer, Integer> map = new TreeMap<Integer,Integer>();
		for(int i=0;i<N;i++){
			// 时间  等级
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			map.put(v1, v2);
			c[i] = v1;
			c[i] = v2;
		}
		//任务
		for(int i=0;i<M;i++){
			int v11 = sc.nextInt();
			int v22 = sc.nextInt();
			map.put(v11, v22);
			a[i] = v11;
			b[i] = v22;
		}
		
		Arrays.sort(a);
		Arrays.sort(c);
		
		Arrays.sort(b);
		Arrays.sort(d);
		
		int count = 0;
		int sum = 0;
		int r = M-1;
		int k = N-1;
		
		while(r>=0 && k >= 0){
			if(a[r] >= c[k]){
				if(b[r] >= d[k]){
					count++;
					sum += 200*a[r] + 3*c[r];
				}else{
					k--;
				}
				r--;
			}
		}
		System.out.println(count);
		System.out.println(sum);
	}

}
