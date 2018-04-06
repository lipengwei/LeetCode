package DP;

/*
 * leetcode 91
 */
public class DecodeWays {

	public static void main(String[] args) {
		System.out.println(numD("10"));
	}
	
	/*
	 * 自上而下
	 */
	public static int numD(String s){
		int n = s.length();
		if(n == 0 || s == null){ 
			return 0;
		}
		int [] memo = new int[n + 1];
		memo[0] = 1;
		memo[1] = s.charAt(0) == '0'?0:1;
		for(int i= 2;i<=n;i++){
			if(s.charAt(i-1) != '0'){
				memo[i] += memo[i - 1];
			}
			int val = Integer.valueOf(s.substring(i - 2, i));
			if(val >= 10 && val <= 26){
				memo[i] += memo[i-2];
			}
		}
		return memo[n];
	}
	
	/*
	 * 自底向上
	 */
	public static int numDec(String s) {
		char [] c = s.toCharArray();
		int n = s.length();
		if(n == 0){ 
			return 0;
		}
		int [] memo = new int[n + 1];
		
		memo[n] = 1;
		memo[n - 1] = s.charAt(n-1) != '0' ? 1 : 0;
		
		for (int i = n - 2; i >= 0; i--)
            if (s.charAt(i) == '0') continue;
            else memo[i] = (Integer.parseInt(s.substring(i,i+2))<=26) ? memo[i+1]+memo[i+2] : memo[i+1];
            
		return memo[0];
	}
	
	public static int numDecodings(String s, int [] memo) {
		boolean flag = false;
		while(s.startsWith("10") || s.startsWith("20")){
			s = s.substring(2);
			flag = true;
		}
		if(s.length() == 0 && flag == true){
			return 1;
		}
		s = s.replace("10", "").replace("20", "");
		if(s.contains("0")){
			return 0;
		}else{
			if(s.length() == 1){
				return 1;
			}else if(s.length() == 2){
				if(Integer.parseInt(s) > 26){
					return 1;
				}else{
					return 2;
				}
			}else if(s.length() > 2){
				if(Integer.parseInt(s.substring(0, 2)) > 26){
					if(memo[s.substring(1).length()] != -1){
						return memo[s.substring(1).length()];
					}else{
						memo[s.substring(1).length()] = numDecodings(s.substring(1), memo);
					}
					return memo[s.substring(1).length()];
				}else{
					
					if(memo[s.substring(1).length()] == -1){
						memo[s.substring(1).length()] = numDecodings(s.substring(1), memo);
					}
					if(memo[s.substring(2).length()] == -1){
						memo[s.substring(2).length()]  = numDecodings(s.substring(2), memo);
					}
					return memo[s.substring(1).length()] + memo[s.substring(2).length()];
				}
			}else{
				return 0;
			}
		}
    }
	
	
}
