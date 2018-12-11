package LeetCode_Medium;

import java.util.Stack;

public class VerifyPreorderSequenceInBST {
	public boolean verifyPreorder(int[] preOrder) {
		Stack<Integer> stack = new Stack<Integer>();
		int root = Integer.MIN_VALUE;
		for (int i = 0; i < preOrder.length; i++) {
			if (preOrder[i] < root) {
				return false;
			}
			while (!stack.isEmpty() && stack.peek() < preOrder[i]) {
				root = stack.peek();
				stack.pop();
			}
			stack.push(preOrder[i]);
		}
		return true;
	}
}
