package ACMCODER;

import java.util.Scanner;
public class DecreaseEandW {
	
/*
 * ������ַ����м仭���ߣ�ͳ�����E������+�ұ�W������ ����Сֵ
 * ��ͳ�� �Ӹ���λ�û����ߺ� ���������E��������������e[i]��ʾ������i��λ�ã��������E������
 * Ȼ���ͷ�������� e[i] + �����ұߵ�W�ĸ�����������Сֵ
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
