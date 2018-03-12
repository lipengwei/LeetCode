package easy;

import java.util.HashMap;
import java.util.Map;

public class SumTest {

	public static void main(String[] args) {
//		System.out.println(Math.pow(-1, 3));
//		System.out.println(getSum(10));
//		int ac[] = {2,3,0,1,4};
//		System.out.println(ac.length);
//		System.out.println(canReachLast(ac));
		System.out.println(getAllChoice(12345));
	}
	
	public static int getSum(int n){
		int sum = 0;
		for(int i=1;i<=n;i++){
			sum += Math.pow(-1, i+1)*i;
		}
		return sum;
	}
	
	public static boolean canReachLast(int[] arr){
		int i = 0;
		int position_val= arr[i];
		while(i<arr.length-1 && position_val !=0){
			System.out.println(position_val);
			i += position_val;
			position_val = arr[i];
		}
		if(i == arr.length-1){
			return true;
		}else{
			return false;
		}
	}
	
	public static int getAllChoice(int num){
//		String strs = String.valueOf(num);
		int count = 0;
		String [] arr = {"a", "b", "c", "d", "e", "f","g",
				"h", "i", "j", "k", "l", "m", "n",
				"o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
		String st = "";
		while(num>0){
			st = arr[num%10-1] + st;
			num = num/10;
		}
		System.out.println(st);
		
		String st1 = "";
		while(num>0){
			if(10 <num%100 && num%100 <= 26){
				st1 = arr[num%100-1] + st;
			}
		}
		return count;
	}
}
