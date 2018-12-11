package Amazon;

import java.util.Stack;

public class Valid_Parentheses {
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '{' || s.charAt(i) == '(' || s.charAt(i) == '[')
				stack.push(s.charAt(i));
			else if (s.charAt(i) == ')' && stack.peek() == '(' && !stack.isEmpty())
				stack.pop();
			else if (s.charAt(i) == '}' && stack.peek() == '{' && !stack.isEmpty())
				stack.pop();
			else if (s.charAt(i) == ']' && stack.peek() == '[' && !stack.isEmpty())
				stack.pop();
			else
				return false;

		}
		return stack.isEmpty();
	}
}
