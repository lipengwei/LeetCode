package sort;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SameChar {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String s1 = s.next();
		String s2 = s.next();
		
		System.out.println(judge(s1.length() > s2.length()?s1:s2, s1.length() >= s2.length()?s2:s1));
	}
	
	public static boolean judge(String s1, String s2){
		Map<Character,Integer> m1 = new HashMap<Character, Integer>();
		for(char c : s1.toCharArray()){
			if(m1.containsKey(c)){
				m1.put(c, m1.get(c) + 1);
			}else{
				m1.put(c, 1);
			}
		}
		
		for(char c : s2.toCharArray()){
			if(m1.containsKey(c)){
				m1.remove(c);
			}
		}
		return m1.isEmpty();
	}

}
