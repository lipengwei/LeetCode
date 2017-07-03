package easy;

/* 回文数字
 * 判断一个数字是不是回文
 * 负整数不是回文数
 * 不要使用额外的空间
 */
public class Palindrome_Number {

	public static void main(String[] args) {
		int x = 0;
		if (x < 0 || x > Integer.MAX_VALUE || (x%10==0 && x!=0)){
			System.out.println(false);
		} else {
			// 方法二 循环整数长度的一半  例如 123321 最后得到两个数 y = 123 x = 123   返回 x==y || x == y/10
			int y = 0;
			while(x > y){
				y = y*10 + x%10;
				x = x/10;
			}
			if (x==y || x==y/10){
				System.out.println(true);
			}else{
				System.out.println(false);
			}
		}
	}
	// 通过reverse来判断
	public static int reverse(int x){
		int y = 0;
		while(x != 0){
			int tail = x % 10;
			int newresult = y*10 + tail;
			if ((newresult - tail) / 10 != y){
				return 0;
			}
			y = newresult;
			x = x / 10;
		}
		return y;
	}
}
