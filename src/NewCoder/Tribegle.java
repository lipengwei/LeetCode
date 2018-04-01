package NewCoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Tribegle {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<HashSet> trSet = new ArrayList<HashSet>();
		for(int i=1;i<=n;i++){
			for(int j=1;j<=n;j++){
				for(int k=1;k<=n;k++){
					if(Judge(i,j,k)){
						int [] ar = new int[]{i,j,k};
						Arrays.sort(ar);
						List l = Arrays.asList(ar);
						HashSet<Integer> tsi = new HashSet<Integer>(l);
						trSet.add(tsi);
					}
				}
			}
		}
		System.out.println(new HashSet(trSet).size());
	}
	
	public static boolean Judge(int i,int j,int k){
		if(i == j || j == k || i == k){
			return false;
		}
		if(i + j > k || i-j < k){
			return true;
		}
		return false;
	}
}
