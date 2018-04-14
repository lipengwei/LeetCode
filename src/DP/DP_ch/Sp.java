package DP.DP_ch;

import java.util.Scanner;
import java.util.Stack;

public class Sp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		String[] sts = new String[n];
		for(int i=0;i<n;i++){
			sts[i] = sc.next();
		}
		
		for(String s:sts){
			prt(s);
		}
	}
	
	public static void prt(String str){
		Stack<Character> st = new Stack<Character>();
		int count = 0;
		for(char s:str.toCharArray()){
			if(s == '('){
				st.push(s);
			}else{
				if(!st.isEmpty()){
					if(s == ')'){
						st.pop();
					}
				}else{
					st.push('(');
					count++;
				}
			}	
		}
		if(st.isEmpty() && count == 1){
			System.out.println("Yes");
		}else{
			if(st.size() == 2 && count == 1){
				System.out.println("Yes");
			}else{
				System.out.println("No");
			}
		}
	}
}
