package easy;

/**
 * ��֤���Ĵ� ���Կո� ��Сд �� �����ַ�
 * @author ����ΰ
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
