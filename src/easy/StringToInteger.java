package easy;

import java.util.ArrayList;
import java.util.List;

/*
 * 字符串转换成int  规则：过滤掉字符串的空格，直到遇见一个字符开始，遇到非数字字符停止，如果字符不能转换成int，返回0，
 * "+1" -- 1   "-1" -- -1
 */
public class StringToInteger {

	public static void main(String[] args) {
		String str = "-1";
		int atoi = myAtoi(str);
		System.out.println(atoi);
	}
	
	public static int myAtoi(String str) {
		List<String> digit = new ArrayList<String>();
		String a = "";
		String symbol = "";
		int result = 0;
		if(str.isEmpty() || str.trim().isEmpty()){
			return 0;
		}else{
			str = str.trim();
			if(str.charAt(0) == '-'){
				symbol = "-";
				str = str.substring(1, str.length());
			}else if(str.charAt(0) == '+'){
				str = str.substring(1, str.length());
			}
			if (str.isEmpty()){
				return 0;
			}
			for(int i=0;i<str.length();i++){
				if(Character.isDigit(str.toCharArray()[i])){
					digit.add(str.substring(i, i+1));
				}else{
					break;
				}
			}
			for(int j=0;j<digit.size();j++){
				a = a+digit.get(j);
			}
		}
		if(a.isEmpty()){
			return 0;
		}else{
			a = symbol+a;
			try {
				result = Integer.parseInt(a);
			} catch (Exception e) {
				if(symbol == "-"){
					result = Integer.MIN_VALUE;
				}else{
					result = Integer.MAX_VALUE;
				}
			}
			return result;
		}
    }
}
