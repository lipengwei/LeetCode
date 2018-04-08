package DP;

/*
 * leetcode 62
 */
public class UniquePath {

	public static void main(String[] args) {
//		System.out.println(uniquePaths(1,1);
		int [][] a = {{0},{0}};
		System.out.println(uniquePathsWithObstacles(a));
	}

	public static int uniquePaths(int m, int n) {
		int[][] path = new int[m][n];
        for(int i=0;i<m;i++){
        	for(int j=0;j<n;j++){
        		if(i == 0 && j==0){
        			path[i][j] = 1;
        		}else if(i == 0 && j > 0){
        			path[i][j] = 1;
        		}else if(i>0 && j == 0){
        			path[i][j] = 1;
        		}else{
        			path[i][j] = path[i-1][j] + path[i][j-1];
        		}
        	}
        }
		return path[m-1][n-1];
    }
	
	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if(obstacleGrid == null || obstacleGrid[0][0] == 1){
			return 0;
		}
		int m = obstacleGrid.length;
		int n= obstacleGrid[0].length;
		int[][] path = new int[m][n];
		for(int i=0;i<m;i++){
        	for(int j=0;j<n;j++){
        		if(i == 0 && j==0){
        			if(obstacleGrid[i][j] != 1) path[i][j] = 1;
        		}else if(i == 0 && j > 0){
        			if(obstacleGrid[i][j] != 1) path[i][j] = 1;
        			else break;
        		}else if(i>0 && j == 0){
        			if(path[i-1][j] == 0){
        				path[i][j] = 0;
        			}else{
        				if(obstacleGrid[i][j] != 1) path[i][j] = 1;
        				else path[i][j] = 0;
        			}
        		}else{
        			if(obstacleGrid[i][j] != 1){
        				path[i][j] = path[i-1][j] + path[i][j-1];
        			}else{
        				path[i][j] = 0;
        			}
        		}
        	}
        }
		return path[m-1][n-1];
    }
}
