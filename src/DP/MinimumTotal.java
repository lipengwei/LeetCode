package DP;

import java.util.ArrayList;
import java.util.List;

/*
 * leetcode 120 
 */
public class MinimumTotal {

	public static void main(String[] args) {
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		for(int i=0;i<4;i++){
			if(i == 0){
				List<Integer> list = new ArrayList<Integer>();
				list.add(2);
				triangle.add(list);
			}
			if(i == 1){
				List<Integer> list = new ArrayList<Integer>();
				list.add(3);
				list.add(4);
				triangle.add(list);
			}
			if(i == 2){
				List<Integer> list = new ArrayList<Integer>();
				list.add(6);
				list.add(5);
				list.add(7);
				triangle.add(list);
			}
			if(i == 3){
				List<Integer> list = new ArrayList<Integer>();
				list.add(4);
				list.add(1);
				list.add(8);
				list.add(3);
				triangle.add(list);
			}
		}
		System.out.println(minimumTotal(triangle));
	}
	
	public static int minimumTotal(List<List<Integer>> triangle) {
		int [][] trig = new int[triangle.size()][triangle.size()];
        int i = 0;
        for(List<Integer> li:triangle){
        	int j = 0;
        	for(Integer l:li){
        		if(j==0 && i==0){
        			trig[i][j] = l;
        		}
        		if(i > 0 && j==0){
        			trig[i][j] = trig[i-1][j] + l;
        		}
        		if(i>0 && j>0 && i!=j){
        			trig[i][j] = Math.min(trig[i-1][j-1], trig[i-1][j]) + l;
        		}
        		if(i>0 && j>0 && i==j){
        			trig[i][j] = trig[i-1][j-1] + l;
        		}
        		j++;
        	}
        	i++;
        }
        
        int sum = trig[trig.length-1][0];
        for(int k=1;k<trig[trig.length-1].length;k++){
        	if(sum > trig[trig.length-1][k]){
        		sum = trig[trig.length-1][k];
        	}
        }
		return sum;
    }

}
