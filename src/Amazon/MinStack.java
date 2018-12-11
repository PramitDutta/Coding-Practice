package Amazon;

import java.util.Stack;

public class MinStack {
	private int min = Integer.MAX_VALUE;
	private Stack<Integer> stack;

	public MinStack() {
		stack = new Stack<Integer>();

	}

	public void push(int x) {
		if (x <= min) {
			stack.push(min);
			min = x;
		}
		stack.push(x);
	}

	public void pop() {
		if (stack.pop() == min)
			min = stack.pop();
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return min;
	}

	public static void main(String[] args) {
		MinStack obj = new MinStack();
		obj.push(2);
		obj.push(3);
		obj.push(-1);
		System.out.println(obj.min);
	}
}
