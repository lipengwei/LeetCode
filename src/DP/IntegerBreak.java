package DP;

/*
 * leetcode 343
 */
public class IntegerBreak {

	public static void main(String[] args) {
		System.out.println(integerBreak(4));
	}
	
	public static int integerBreak(int n) {
		int[] memo = new int[n+1];
		memo[1] = 1;
		for(int i=2;i<=n;i++){
			// 求解memo[i]
			for(int j=1;j<=i-j;j++){
				// j + (i-j)
				memo[i] = Math.max(Math.max(memo[i], j*(i-j)), j*memo[i-j]);
			}
		}
		return memo[n];
    }
	
	// 记忆化搜索方法
	public static int integerBreak1(int n) {
		int[] memo = new int[n+1];
		return ib(n,memo);
    }
	
	
	public static int ib(int n, int[] memo){
		int res = 0;
		if(n == 1){
			return 1;
		}
		if(memo[n] != 0){
			return memo[n];
		}else{
			for(int i=1; i<n; i++)
				res = Math.max(Math.max(res, i*(n-i)), i*ib(n-i,memo));
			memo[n] = res;
			return res;
		}
	}
}
