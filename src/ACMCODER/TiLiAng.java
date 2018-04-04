package ACMCODER;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TiLiAng {

	public static void main(String[] args) {
		//输入
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String [][] mat = new String[N][6];
		for(int i=0;i<N;i++){
			for(int j=0;j<6;j++){
				String st = sc.next();
				mat[i][j] = st;
			}
		}
		//计算
		Map<String,Integer> res = new HashMap<String,Integer>();
		int total = 0;
		for(int i=0;i<N;i++){
			int sum = Calc(mat[i]);
			res.put(mat[i][0], sum);
			total += sum;
		}
		int max = 0;
		String name = "";
		for(Map.Entry<String, Integer> entry:res.entrySet()){
			if(entry.getValue() > max){
				max = entry.getValue();
				name = entry.getKey();
			}
		}
		
		System.out.println(name);
		System.out.println(max);
		System.out.println(total);
		
		
	}
	
	public static int Calc(String[] mat){
		int sum = 0;
		// a=作战能力 b=声望 c=军官 d=灼人成员 x=特殊能力
		int a = Integer.parseInt(mat[1]);
		int b = Integer.parseInt(mat[2]);
		String c = mat[3];
		String d = mat[4];
		int x = Integer.parseInt(mat[5]);
		
		if(a > 80 && x > 0) sum += 8000;
		if(a > 85 && b > 80) sum += 4000;
		if(a > 90) sum += 2000;
		if(a > 85 && d.equals("Y")) sum += 1000;
		if(b > 80 && c.equals("Y")) sum += 850;
		
		return sum;
	}
	
}
