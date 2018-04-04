package ACMCODER;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lian {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> list1 = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();
		String s1 = sc.nextLine();
		for(int i=0;i<s1.split(" ").length;i++){
			list1.add(Integer.parseInt(s1.split(" ")[i]));
		}
		
		String s2 = sc.nextLine();
		for(int i=0;i<s2.split(" ").length;i++){
			list2.add(Integer.parseInt(s2.split(" ")[i]));
		}
		
		int i = 0;
		int j = 0;
		if(list1.get(i) > list2.get(j)){
			System.out.println(">");
		}else if(list1.get(i) < list2.get(j)){
			System.out.println("<");
		}else{
			i++;
			j++;
			while(i<list1.size() && j<list2.size()){
				if(list1.get(i) > list2.get(j)){
					System.out.println("<");
					break;
				}else if(list1.get(i) < list2.get(j)){
					System.out.println(">");
					break;
				}
				i++;
				j++;
			}
			if(list1.size() > list2.size()){
				System.out.println(">");
			}else if(list1.size() < list2.size()){
				System.out.println("<");
			}else{
				System.out.println("=");
			}
		}
	}

}
