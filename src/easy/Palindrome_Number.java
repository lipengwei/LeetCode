package easy;

/* ��������
 * �ж�һ�������ǲ��ǻ���
 * ���������ǻ�����
 * ��Ҫʹ�ö���Ŀռ�
 */
public class Palindrome_Number {

	public static void main(String[] args) {
		int x = 0;
		if (x < 0 || x > Integer.MAX_VALUE || (x%10==0 && x!=0)){
			System.out.println(false);
		} else {
			// ������ ѭ���������ȵ�һ��  ���� 123321 ���õ������� y = 123 x = 123   ���� x==y || x == y/10
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
	// ͨ��reverse���ж�
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
