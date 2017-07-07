package easy;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * TestCase: [(2e0,true) (0e,false) (0.., false) (3., true) (..2, false) (46.e3 true) (.-1, false) (-.3e6, true)
 * (.1. false) (1 .,false) (Y+.,false) (1 4, false) (-01, true) (+.8, true) (.2e81 true) (4e3., false) (005047e+6, true)]
 */
public class ValidNumber {
	public static void main(String[] args) {
		String str = "3.";
		ArrayList<String> ast = new ArrayList<String>();
		ast.add("2e0");
		ast.add("3.");
		ast.add("46.e3");
		ast.add("-.3e6");
		ast.add("+.8");
		ast.add(".2e81");
		ast.add("4e3.");
		ast.add("-01");
		ast.add(".-1");
		ast.add("1 4");
		ast.add("005047e+6");
		ast.add("32.e-80123");
		ast.add(".86e4");
		System.out.println(Double.parseDouble("005047e+6"));
		for(String str1:ast){
			boolean result = is_Number(str1);
		}
//		boolean result = is_Number(str);
//		System.out.println(result);
	}
	
	public static boolean is_Number(String s) {
		s = s.trim();
		boolean rs = false;
		String regx = "";
		if(s.contains("e")){
			regx = "[+|-]?((\\.)(\\d+)|(\\d+)(\\.)(\\d+)|(\\d+)(\\.)?)e[+|-]?(\\d+)|";
		}else{
			regx = "[+|-]?((\\.)(\\d+)|(\\d+)(\\.)(\\d+)|(\\d+)(\\.)?)";
		}
        Matcher matcher = Pattern.compile(regx).matcher(s);
        rs = matcher.matches();
		return rs;
	}
	
	public static boolean isNumber(String s) {
		String random_str = s.trim();
		s = s.trim();
		
		if(s.isEmpty() || s.contains(" ")){
			return false;
		}else if(s.contains("e")){
			System.out.println(s.split("e").length);
			if(s.split("e").length == 2){
				String [] strs = s.split("e");
				for(String st:strs){
					if(st.isEmpty()){
						return false;
					}
					System.out.println(st);
					for(int i=0;i<st.length();i++){
						if(!Character.isDigit(st.charAt(i))){
							return false;
						}
					}
				}
			}else if(s.split("e").length > 2 || s.split("e").length == 0 || s.split("e").length == 1){
				return false;
			}
		}else if(s.contains(".")){
			int m = 0;
			while(random_str.endsWith(".") || random_str.startsWith(".")){
				if(random_str.endsWith(".")){
					m ++;
					random_str = random_str.substring(0, random_str.length()-1);
				}
				if(random_str.startsWith(".")){
					m ++;
					random_str = random_str.substring(1, random_str.length());
				}
			}
			if(m>1){
				return false;
			}
			String [] strs = s.split("\\.");
			if(s.split("\\.").length == 2){
				for(String st:strs){
					for(int i=0;i<st.length();i++){
						if(!Character.isDigit(st.charAt(i))){
							return false;
						}
					}
				}
			}else if(s.split("\\.").length > 2 || s.split("\\.").length == 0){
				return false;
			}
		}else if(s.contains("..")){
			return false;
		}
		else{
			for(int i=0;i<s.length();i++){
				if(!Character.isDigit(s.charAt(i))){
					return false;
				}
			}
		}
		return true;
    }
}
