package DP;

import java.util.Arrays;
import java.util.Scanner;
/*
 * 输入一串数字，求组不成数字的最小值
 * （5，4）-1；（1，2，4）-3；（1，2，3，4，5，7，8，9）-10
 */
public class MS {

	public static void main(String[] args) {
		int no = 0;
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		if(str.contains("0") && !str.contains("1")){
			no = 1; 
		}
		if(str.contains("0") && str.contains("1")){
			no = getNo(str);
		}
		if(str.contains("1") && !str.contains("0")){
			no = 10;
		}
		if(!str.contains("1") && !str.contains("0")){
			no = 1;
		}
		System.out.println(no);
	}
	
	public static int getNo(String str){
		char[] sr = str.toCharArray();
		Arrays.sort(sr);
		char c = sr[sr.length-1];
		int j = Integer.parseInt(c+"")+1;
		return j;
	}
}
