package DP.DP_ch;

import java.util.Scanner;

public class HUI {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
        while(input.hasNext()) {
            String s = input.nextLine();
            int len = s.length();
            int ans = len;
            for(int i = 0; i < len; i++) {
                //连续回文字串长度可能为奇数
                for(int l = i - 1, r = i + 1; l >= 0 && r < len && s.charAt(l) == s.charAt(r); l--, r++, ans++);
                //连续回文字串长度可能为偶数
                for(int l = i, r = i + 1; l >= 0 && r < len && s.charAt(l) == s.charAt(r); l--, r++, ans++);
            }
            System.out.println(ans);
        }
	}

	public static void prt(String s){
		int judge = 0;
		int num = 0;
		int i=0;
		while(i<s.length()){
			if(s.charAt(i) == '('){
				judge += 1;
				i += 1;
			}else if(s.charAt(i) == ')'){
				judge -= 1;
				i += 1;
			}
		    if( judge < 0)
		        num += 1;
		}
		if( (judge == 0) && (num == 1))
		    System.out.println("Yes");
		else
			System.out.println("No");
	}
}
