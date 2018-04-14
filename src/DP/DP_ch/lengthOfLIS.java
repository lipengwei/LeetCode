package DP.DP_ch;

/*
 * leetcode 300
 * 
 */
public class lengthOfLIS {

	public static void main(String[] args) {
		int[] a = {1,3,6,7,9,4,10,5,6};
		System.out.println(lengthOfLIS(a));
	}
	
	public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if(n == 0){
        	return 0;
        }
        int [] a = new int[n];
        for(int i=0;i<n;i++){
        	a[i] = 1;
        }
        int max = 0;
        for(int i=1;i<n;i++){
        	// 以i结束的最长递增子序列 
        	for(int j=0;j<i;j++){
        		// 循环   0-i 求出最优值
        		a[i] = Math.max(a[i], nums[i] > nums[j]?(1 + a[j]):a[i]);
        		max = Math.max(max, a[i]);
        	}
        }
		return max;
    }

}
