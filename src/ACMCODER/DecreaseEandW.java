package ACMCODER;

import java.util.Scanner;
public class DecreaseEandW {
	
/*
 * 在这个字符串中间画竖线，统计左边E的数量+右边W的数量 的最小值
 * 先统计 从各个位置画竖线后 把竖线左边E的数量存起来，e[i]表示画到第i个位置，竖线左边E的数量
 * 然后从头遍历，用 e[i] + 竖线右边的W的个数，计算最小值
 */
	public static void main(String[] args) {
		String str = "EEWEWWEW";
		Scanner sc = new Scanner(System.in);
		char[] s = sc.nextLine().toCharArray();
		int l = s.length;
		int[] e = new int[l];
		
		if (l > 0)
			e[0] = s[0] == 'E'?1:0; 
		for (int i = 1; i<l; i++)  
			e[i] = e[i-1] + (s[i] == 'E'?1:0);
		
		int ans = l - e[l-1];
		for (int i = 0; i<l; i++) {
			int res = e[i] + ((l - i - 1 - (e[l - 1] - e[i])));
			if (ans > res) 
				ans = res;
		}
		System.out.println(ans);
	}

}
