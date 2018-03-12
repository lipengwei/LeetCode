package easy.day2;

import java.util.ArrayList;
import java.util.List;

/*
 * 左下或者右上查找 向上较小，想左增大
 */
public class BinarySearch {

	public static void main(String[] args) {
		List<Integer> as = new ArrayList<Integer>();
//		int[][] a = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
////		System.out.println(bsearch(a, 1));
//		System.out.println(find(6, a));
//		System.out.println(rectCover(4));
		StringBuffer str = new StringBuffer("how are you");
		System.out.println(replaceSpace(str));
	}
	public static String replaceSpace(StringBuffer str) {
        int blanknum = 0;
        for(int i=0;i < str.length();i++){
            if(str.charAt(i) == ' '){
                blanknum++;
            }
        }
        int indexold = str.length() - 1;
        int newlength = str.length() + (blanknum << 1);
        int indexnew = newlength - 1;
        System.out.println(str.length());
        str.setLength(newlength);
        System.out.println(str.length());
        for(;indexold >= 0 && indexold < indexnew;indexold--){
            if(str.charAt(indexold) == ' '){
                str.setCharAt(indexnew--, '0');
                str.setCharAt(indexnew--, '2');
                str.setCharAt(indexnew--, '%');
            }else{
                str.setCharAt(indexnew--,str.charAt(indexold));
            }
        }
        return str.toString();
    }
	
	public static int rectCover(int number) {
		if(number <= 2) return number;
		int a=1, b=2, cnt = 2;
		while(cnt < number){
			b += a;
			a = b - a;
			cnt ++;
		}
	    return b;
	}
	
	public static boolean bsearch(int[][] array, int target){
		int m = array.length - 1;
		int x = 0;
		int n = array[0].length;

		while(m >= 0 && x < n){
			if(array[m][x] == target){ return true;}
			if(array[m][x] > target){
				m--;
			}else{
				x++;
			}
		}
		return false;
	}
    
	public static boolean bs(int[] array, int key){
		int low = 0;
		int high = array.length-1;
		int mid;
		while(low<= high){
			mid = (low+high)/2;
			if(array[mid] == key){
				return true;
			}else if(array[mid] > key){
				high = mid - 1;
			}else{
				low = mid + 1;
			}		
		}
		return false;
	}
	
	public static boolean find(int target, int[][] array){
		int x = array.length - 1;
		for(int i=0;i<=x;i++){
			if(bs(array[i], target)){
				return true;
			}
		}
		return false;
	}
}
