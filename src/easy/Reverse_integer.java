package easy;

public class Reverse_integer {
	public static void main(String[] args) {
//		int x = -2147483412;
		int x = 2147483647;
		// 方法一  转换成string通过parseInt报异常返回0
//		String s = String.valueOf(x);
//		String symbol = "";
//		int k = 0;
//		if (s.charAt(0) == '-'){
//			symbol = "-";
//			s = s.substring(1, s.length());
//		}
//		for(int i=s.length()-1;i>=0;i--){
//			symbol += s.toCharArray()[i];
//		}
//		try {
//			k = Integer.parseInt(symbol);
//		} catch (Exception e) {
//		    k = 0;
//		}
//		System.out.println(k);
		//方法二
		int result = 0;
	    while (x != 0)
	    {
	        int tail = x % 10;
	        int newResult = result * 10 + tail;
	        if ((newResult - tail) / 10 != result){
	        	System.out.println(0);
	        }
	        result = newResult;
	        x = x / 10;
	    }
	    System.out.println(result);
	}
}
