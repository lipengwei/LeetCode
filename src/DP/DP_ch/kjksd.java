package DP.DP_ch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class kjksd {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] B  = new int[N+M];
		int[] A = new int[M];
		Map<Integer,Integer> tm = new HashMap<Integer,Integer>();
		int v1=0,v2 =0;
		for(int i=0;i<N;i++){
			v1 = sc.nextInt();
			v2 = sc.nextInt();
			B[i] = v1;
			tm.put(v1, v2);
		}
		int v = 0;
		for(int j=0;j<M;j++){
			v = sc.nextInt();
			A[j] = v;
			B[N+j] = v;
			if(!tm.containsKey(v)){
				tm.put(v, 0);
			}
		}
		Pvalue(B,0,B.length-1);
		int max = 0;
		for(int i=0;i<B.length;i++){
			max = Math.max(max, tm.get(B[i]));
			tm.put(B[i], max);
		}
		for(int j=0;j<A.length;j++){
			System.out.println(tm.get(A[j]));
		}
 	}
	
	public static void Pvalue(int[] b, int low, int high){
		if(low < high){
			int position = Partion(b, low, high);
			Pvalue(b,low,position-1);
			Pvalue(b,position+1,high);
		}
	}
	public static int Partion(int [] b,int low,int high){
		int p = b[low];
		while(low < high){
			while(low < high && b[high] >= p) {
				--high;
			}
			b[low]=b[high];
			while(low < high && b[low] <= p) {
				++low;
			}
			b[high] = b[low];
		}
		b[low] = p;
		return low;
	}
//	public static int BinarySearch(int a, int[][] inits){
//		int p = 0;
//		int low = 0;
//		int high = inits.length -1;
//		int mid;
//		
//		while(low<=high){
//			mid = (low + high) >> 1;
//			if(inits[mid][0] < a){
//				low=mid + 1;
//				if(low > high){
//					p = p > inits[high][1]?p:inits[high][1];
//					return p;
//				}
//				if(inits[low][0] > a){
//					p = p > inits[low-1][1]?p:inits[low-1][1];
//					return p;
//				}
//			}else{
//				high = mid - 1;
//				if(high < low){
//					p = inits[low][0] <= a?inits[low][1]:-1;
//					return p;
//				}
//				if(inits[high][0] < a){
//					p = p>inits[high][1]?p:inits[high][1];
//					return p;
//				}
//			}
//		}
//		return -1;
//	}
	
//	public static void QuickSort(int [][] inits, int low, int high){
//		if(low < high){
//			int pivot = Partion(inits,low,high);
//			QuickSort(inits,low,pivot-1);
//			QuickSort(inits,pivot+1,high);
//		}
//	}
//	
//	public static int Partion(int [][] inits, int low, int high){
//		int index_1 = inits[low][0];
//		int index_2 = inits[low][1];
//		while(low < high){
//			while(low<high && inits[high][0]>=index_1){
//				--high;
//			}
//			inits[low][0] = inits[high][0];
//			inits[low][1] = inits[high][1];
//			while(low<high && inits[low][0]<=index_1){
//				++low;
//			}
//			inits[high][0] = inits[low][0];
//			inits[high][1] = inits[low][1];
//		}
//		inits[low][0] = index_1;
//		inits[low][1] = index_2;
//		return low;
//	}
}