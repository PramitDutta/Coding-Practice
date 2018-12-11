package LeetCode_Medium;

import java.util.Stack;

public class ReversePolishNotation {
	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<Integer>();
		for (String s : tokens) {
			if (s.equals("+")) {
				stack.add(stack.pop() + stack.pop());
			} else if (s.equals("/")) {
				int b = stack.pop();
				stack.add(stack.pop() / b);
			} else if (s.equals("-")) {
				int b = stack.pop();
				stack.add(stack.pop() - b);
			} else if (s.equals("*")) {
				stack.add(stack.pop() * stack.pop());
			} else {
				stack.add(Integer.parseInt(s));
			}
		}
		return stack.pop();
	}
}
