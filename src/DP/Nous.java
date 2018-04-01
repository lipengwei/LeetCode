package DP;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Nous {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		double [][] arr = new double[n+1][n+1];
		Set<Double> ars = new HashSet<Double>();
		for(int i=1;i<=n;i++){
			for(int j = 1;j<=n;j++){
				arr[i][j] = (double)i/j;
				System.out.println(arr[i][j]);
//				System.out.println(i+"--"+j);
				ars.add(arr[i][j]);
			}
		}
		System.out.println(ars.size()+2);
	}

}
