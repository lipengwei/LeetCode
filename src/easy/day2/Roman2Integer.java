package easy.day2;

import java.util.HashMap;
import java.util.Map;

/*
 * 罗马数字转换成 整数
 * 第一，如果当前数字是最后一个数字，或者之后的数字比它小的话，则加上当前数字
 * 第二，其他情况则减去这个数字
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
