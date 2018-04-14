package DP.DP_ch;

/*
 * leetcode 309
 * explain: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/discuss/75929/7-line-Java:-only-consider-sell-and-cooldown
 */

public class maxProfit {

	public static void main(String[] args) {
		int[] a = {1,2,3,0,2};
		System.out.println(maxProfit(a));
	}
	
	public static int maxProfit(int[] prices) {
		int n = prices.length;
        int []p1 = new int[n];
        int []p2 = new int[n];
        p1[0] = 0;
        p2[0] = 0;
        for(int i=1;i<n;i++){
        	p1[i] = Math.max(p1[i-1] + prices[i] - prices[i-1], p2[i-1]);
        	p2[i] = Math.max(p1[i-1], p2[i-1]);
        }
		return Math.max(p1[n-1], p2[n-1]);
    }
}
