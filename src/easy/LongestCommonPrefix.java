package easy;

import java.util.ArrayList;


/*
 * 最长公共前缀 
 * input ["asdfghj", "asdpioue", "asdzcxv"]
 * ouput "asd"
 * 如果list为空，返回 "", 如果list只有一个字符串，返回他本身
 */
public class LongestCommonPrefix {

	public static void main(String[] args) {
		String[] strs = {"aa","ab", "ac", "ad"};
		String longest = longest(strs);
		System.out.println(longest);
	}
	
	public static String longestCommonPrefix(String[] strs) {
		String longest = "";
		if (strs.length == 0){
			return "";
		}else if(strs.length == 1){
			return strs[0];
		}else{
			// 最长的长度
			int len = strs[0].length();
			for (int i=0;i<strs.length;i++){
				if(strs[i].length() < len){
					len = strs[i].length();
				}
			}
			//
			ArrayList<Character> pre = new ArrayList<Character>();
			for (int i=0;i<len;i++){
				pre.add(strs[0].charAt(i));
				int j = 0;
				for(String st:strs){
					if(st.charAt(i) == pre.get(i)){
						j++;
					}
				}
				if(j == strs.length){
					longest += pre.get(i);
				}else{
					return longest;
				}
			}
		}
		return longest;
	}
	
	public static String longest(String[] strs){
		if(strs == null || strs.length == 0)    return "";
	    String pre = strs[0];
	    int i = 1;
	    while(i < strs.length){
	    	System.out.println(strs[i]);
	    	System.out.println(pre);
	    	System.out.println(strs[i].indexOf(pre));
	        while(strs[i].indexOf(pre) != 0)
	            pre = pre.substring(0,pre.length()-1);
	        i++;
	    }
	    return pre;
	}

}
