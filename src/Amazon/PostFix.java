package Amazon;

import java.util.Stack;

public class PostFix {
	public static int postFixEvaluate(String exp) {
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < exp.length(); i++) {
			char c = exp.charAt(i);
			if (Character.isDigit(c)) {
				stack.push(c - '0');
			} else if (c == '+') {
				stack.push(stack.pop() + stack.pop());
			} else if (c == '*') {
				stack.push(stack.pop() * stack.pop());
			} else if (c == '-') {
				int b = stack.pop();
				int a = stack.pop();
				stack.push(a - b);
			} else if (c == '/') {
				int b = stack.pop();
				int a = stack.pop();
				stack.push(a / b);
			}
		}
		return stack.pop();
	}

	public static void main(String[] args) {
		String exp = "682/1-*";
		int result = postFixEvaluate(exp);
		System.out.println(result);
	}
}
