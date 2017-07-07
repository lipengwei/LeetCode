package easy;

import java.util.ArrayList;
import java.util.List;

/*
 * �ַ���ת����int  ���򣺹��˵��ַ����Ŀո�ֱ������һ���ַ���ʼ�������������ַ�ֹͣ������ַ�����ת����int������0��
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
