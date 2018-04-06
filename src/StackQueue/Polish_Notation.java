package StackQueue;

import java.util.Stack;
/*
 * 栈的应用
 * 逆波兰表达式
 */
public class Polish_Notation {

	public static void main(String[] args) {
//		String[] tokens = {"0","3","/"};
//		System.out.println(evalRPN(tokens));
		System.out.println(simplifyPath("/home//foo/"));
	}
	
	public static int evalRPN(String[] tokens) {
		if(tokens.length == 1){
			return Integer.parseInt(tokens[0]);
		}
        Stack<Integer> st = new Stack<Integer>();
        int res = 0;
        for(String c:tokens){
        	if(c == "+" || c == "-" || c == "*" || c.equals("/")){
        		if(!st.isEmpty()){
        			int a = st.pop();
        			int b = st.pop();
        			switch (c) {
						case "+":
							res = b + a;
							break;
						case "-":
							res = b -a;
							break;
						case "*":
							res = b * a;
							break;
						case "/":
							res = (int)b / a;
							break;
						default:
							break;
					}
        			st.push(res);
        		}
        	}else{
        		st.push(Integer.parseInt(c));
        	}
        }
		return res;
    }

	public static String simplifyPath(String path) {
		if(path.equals("/../")){
			return "/";
		}
		path = path.substring(1);
		String[] pa = path.split("/");
        Stack<String> st = new Stack<String>();
        for(String s:pa){
        	if(s.equals(".") || s.equals("/") || s.equals("")){
        		continue;
        	}else if(s.equals("..")){
        		if(!st.isEmpty()){
        			st.pop();
        		}
        	}else{
        		st.push(s);
        	}
        }
        if(st.isEmpty()){
        	return "/";
        }
        String res = "";
        while(!st.isEmpty()){
        	res = "/" + st.pop() + res;
        }
		return res;
    }
	
}
