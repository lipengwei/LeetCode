package easy;

/**
 * 验证回文串 忽略空格 大小写 和 特殊字符
 * @author 李鹏伟
 * leetcode 125
 */

public class ValidPalindrome {

	public static void main(String[] args) {
		String s = ",.";
		System.out.println(isPalindrome(s));
	}
	
	public static boolean isPalindrome(String s) {
		if(s.isEmpty()){
			return true;
		}
		String str = s.replaceAll("\\W", "").toLowerCase();
		System.out.println(str);
		char[] ch = str.toCharArray();
		for(int i = 0;i < ch.length/2; i++){
			if(ch[i] != ch[ch.length - 1 -i]){
				return false;
			}
		}
        return true;
    }
}
