package easy.day2;

import java.util.HashMap;
import java.util.Map;

/*
 * ��������ת���� ����
 * ��һ�������ǰ���������һ�����֣�����֮������ֱ���С�Ļ�������ϵ�ǰ����
 * �ڶ�������������ȥ�������
 */
public class Roman2Integer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "MMMDCCCLXXXVIII";
		int res = 0;
		Map<Character, Integer> m = new HashMap<Character, Integer>();
		m.put('I', 1);
		m.put('V', 5);
		m.put('X', 10);
		m.put('L', 50);
		m.put('C', 100);
		m.put('D', 500);
		m.put('M', 1000);
		
		for(int i=0;i<s.length();++i){
			int val = m.get(s.toCharArray()[i]);
			if (i == s.length()-1 || m.get(s.toCharArray()[i+1]) <= m.get(s.toCharArray()[i])){
				res += val;
			}else{
				res -= val;
			}
		}
		System.out.println(res);
	}
}
