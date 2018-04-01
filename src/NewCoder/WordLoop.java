package NewCoder;
/*
 * 
 * 
 */
import java.util.Scanner;

public class WordLoop {

	public static void main(String[] args) {
		int total = 0;
		Scanner sc = new Scanner(System.in);
		int column = sc.nextInt();
		String[] strs = new String[column];
		String st = "";
		for(int i =0;i<column;i++){
			st = sc.next();
			strs[i] = st;
		}
		System.out.println(strs);
		for(int i=0;i<strs.length;i++){
			int group = 0;
			for(int j=i+1;j<strs.length;j++){
				boolean flag = false;
				if(isLoop(strs[i], strs[j])){
					flag = true;
					strs[j] = "";
				}
				group = (group == 1?group:flag?1:0);
			}
			total += group;
		}
		System.err.println(total);
	}
	
	public static boolean isLoop(String st1, String st2){
		if(st1 == "" || st2 == ""){
			return false;
		}
		int i = 0;
		while(i<st1.length()){
			if((st1.substring(i) + st1.substring(0, i)).equals(st2)){
				return true;
			}
			i++;
		}
		return false;
	}
}
