package ACMCODER;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/*
 * 排队，个高的挡住了个低的，求能看到的士兵数目
 * 使用栈来解决问题
 */
public class Soldier {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T =sc.nextInt();
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		
		for(int i=0;i<T;i++){
			int n = sc.nextInt();
			List<Integer> li = new ArrayList<Integer>();
			for(int j=0;j<n;j++){
				li.add(sc.nextInt());
			}
			list.add(li);
		}
		SeeSoldier(list);
	}
	
	public static void SeeSoldier(List<List<Integer>> list){
		for(int i=0;i<list.size();i++){
			Stack<Integer> st = new Stack<Integer>();
			for(int j=0;j<list.get(i).size();j++){
				if(st.isEmpty()){
					st.push(list.get(i).get(j));
				}else{
					if(list.get(i).get(j) > st.peek()){
						st.push(list.get(i).get(j));
					}
				}
			}
			System.out.println(st.size());
		}
	}
}
