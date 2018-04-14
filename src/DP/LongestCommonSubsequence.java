package DP;

/*
 * 最长公共子序列
 * 
 */
public class LongestCommonSubsequence {

	public static void main(String[] args) {
		String st = new String("asdas");
		Object sss = null;
		try {
			sss = st.getClass().newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(sss.toString());
		
	}

	public static int lcs(String str1, String str2) {  
	    int m = str1.length();
	    int n = str2.length();
	    int[][] c = new int[m+1][n+1];
	    for(int i=0;i<m;i++){
	    	c[m][0] = 0;
	    }
	    for(int i=0;i<n;i++){
	    	c[0][i] = 0;
	    }
	    for(int i = 1;i<m;i++){
	    	for(int j=1;j<n;j++){
	    		if(str1.charAt(i) == str2.charAt(j)){
	    			c[i][j] = 1 + c[i-1][j-1];
	    		}
	    	}
	    }
		return 0;
	}
}
