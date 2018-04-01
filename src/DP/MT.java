package DP;

import java.util.Scanner;

public class MT {

	public static void main(String[] args) {
		int no = 0;
		Scanner sc = new Scanner(System.in);
		String S = sc.next();
		String T = sc.next();
		int t_len = T.length();
		int i=0;
		int j = t_len-1;
		while(j<S.length()){
			String s2 = S.substring(i, j+1);
			System.out.println(T + "--" + s2 + "--" + subStrSum(T,s2));
			no += subStrSum(T,s2);
			i++;
			j++;
		}
		System.out.println(no);
	}
	
	public static int subStrSum(String s1, String s2){
		int sum = 0;
		for(int i=0;i<s1.length();i++){
			if(s1.toCharArray()[i] != s2.toCharArray()[i]){
				sum += 1;
			}
		}
		return sum;
	}
	
}
