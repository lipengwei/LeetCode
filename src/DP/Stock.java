package DP;

import java.util.Scanner;

public class Stock {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int left = sc.nextInt();
		int right = sc.nextInt();
		System.out.println(DT(left, right));
	}
	public static int DT(int left, int right){
		int count = 0;
		for(int i=left;i<= right;i++){
			switch(i%3){
				case 1:break;
				case 2:count++;break;
				case 0:count++;break;
			}
		}
		return count;
	}
	
	public static int DiviThree( int left, int right){
		String start = "";
		for(int j=1;j<left;j++){
			start += String.valueOf(j);
		}
		int di = JudgeNo(start);
		int count = 0;
		for(int i=left;i<=right;i++){
			if((di+i)%3==0){
				count += 1;
				di = 0;
			}else{
				di = (di+i)%3;
			}
		}
		return count;
	}
	
	public static int JudgeNo(String num){
		int sum = 0;
		char[] ch = num.toCharArray();
		for(Character c:ch){
			sum += Integer.parseInt(c+"");
		}
		return sum % 3;
	}
}
