package easy;

import java.util.Stack;

/*
 * 有效的括号 '(', ')', '{', '}', '[' and ']'
 * 用了两个栈才实现的功能
 * TestCase {"((", "([]", "(){[()()[]]}"}
 * 
 */
public class Valid_Parentheses {
	
	public static void main(String[] args) {
		String s = "((";
		boolean b = isValid(s);
		System.out.println(b);
	}
	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		Stack<Character> stack1 = new Stack<Character>();
		for (int i=0;i<s.length();i++){
			stack.push(s.toCharArray()[i]);
		}
		stack1.push(stack.pop());
		while(!stack.isEmpty()){
			if (stack1.isEmpty()){
				stack1.push(stack.pop());
			}
			if (stack.isEmpty()){
				continue;
			}
			if(stack.peek() == '(' && stack1.peek() == ')'){
				stack.pop();
				stack1.pop();
			}else if (stack.peek() == '[' && stack1.peek() == ']'){
				stack.pop();
				stack1.pop();
			}else if (stack.peek() == '{' && stack1.peek() == '}'){
				stack.pop();
				stack1.pop();
			}else {
				stack1.push(stack.pop());
			}
		}
		if (stack.isEmpty() && stack1.isEmpty()){
			return true;
		} else {
			return false;
		}
    }
}
