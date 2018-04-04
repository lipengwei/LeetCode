package DP;

/*
 * leetcode 64
 */
public class MinPathSum {

	public static void main(String[] args) {
		int [][] a = {{1,2},
		              {5,6},
		              {1,1}};
		System.out.println(minPathSum(a));
	}
	
	public static int minPathSum(int[][] grid) {
        int[][] sum = new int[grid.length][grid[0].length];
        for(int i = 0;i<grid.length;i++){
        	for(int j = 0;j<grid[i].length;j++){
        		if(i == 0 && j == 0){
        			sum[i][j] = grid[i][j];
        		}else if(i == 0 && j > 0){
        			sum[i][j] = sum[i][j-1] + grid[i][j];
        		}else if(i > 0 && j == 0){
        			sum[i][j] = sum[i-1][j] + grid[i][j];
        		}else if(i > 0 && j > 0){
        			sum[i][j] = Math.min(sum[i-1][j], sum[i][j-1]) + grid[i][j];
        		}
        	}
        }
		return sum[grid.length-1][grid[grid.length-1].length-1];
    }
}
