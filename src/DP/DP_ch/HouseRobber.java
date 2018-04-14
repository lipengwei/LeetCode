package DP.DP_ch;

/*
 * leetcode 198
 */
public class HouseRobber {

	public static void main(String[] args) {
		int [] a = {1,2,1,0};
		System.out.println(robber2(a));
		
//		int n = a.length;
//		int [] dp = new int[n];
//		dp[0] = a[0];
//		dp[1] = Math.max(a[1], a[0]);
//		for(int i=2;i<n;i++){
//			dp[i] = Math.max(dp[i-2]+a[i], dp[i-1]);
//		}
//		System.out.println(dp[n-1]);
	}
	
	public static int robber2(int[] nums){
		int [] a = nums;
		int n = a.length;
		if(n == 0){
			return 0;
		}else if(n == 1){
			return a[0];
		}else if(n == 2){
			return Math.max(a[0], a[1]);
		}else if(n == 3){
			return Math.max(Math.max(a[0], a[1]), a[2]);
		}
		int [] dp = new int[n];
		int value = a[0];
		dp[1] = a[1];
		dp[2] = Math.max(a[1], a[2]);
		// 不偷1，偷2-n
		for(int i=3;i<n;i++){
			dp[i] = Math.max(dp[i-2]+a[i], dp[i-1]);
		}
		
		// 偷1 不偷最后一个
		int [] dp2 = new int[n-1];
		dp2[0] = a[0];
		dp2[1] = Math.max(a[1], a[0]);
		for(int i=2;i<n-1;i++){
			dp2[i] = Math.max(dp2[i-2]+a[i], dp2[i-1]);
		}
		return Math.max(dp[n-1], dp2[n-2]);
	}
	
	public static int rob2(int[] nums){
		int prev = 0,curr = 0;
		int [] dp = new int[nums.length];
		for(int i=0;i<nums.length;i++){
			int temp = curr;
			curr = Math.max(prev+nums[i], curr);
			prev = temp;
			dp[i] = curr;
		}
		return curr;
	}
	
	public static int rob(int[] nums) {
    	int n = nums.length;
    	if(n <= 0){
    		return 0;
    	}
    	int [] memo = new int[n];
    	memo[n-1] = nums[n-1];
    	for(int i=n-2;i>=0;i--){
    		//求解memo[i]
    		for(int j=i;j<n;j++){
    			memo[i] = Math.max(memo[i], nums[j]+ (j+2<n?memo[j+2]:0));
    		}
    	}
    	return memo[0];
	}
	
    public static int rob1(int[] nums) {
    	int n = nums.length;
    	int [] memo = new int[n];
    	for(int i=0;i<n;i++){
    		memo[i] = -1;
    	}
		int max = getRob(nums,0,memo);
		return max;
    }
	
	public static int getRob(int[] nums, int start, int[] memo){
		int n = nums.length;
		if(start >= n){
			return 0;
		}
		
		if(memo[start] != -1){
			return memo[start];
		}
		int max = 0;
		for(int i=start;i<n;i++){
			max = Math.max(max, nums[i] + getRob(nums,i+2, memo));
		}
		memo[start] = max;
		return max;
	}
}
