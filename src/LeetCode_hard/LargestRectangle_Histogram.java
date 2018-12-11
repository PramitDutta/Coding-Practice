package LeetCode_hard;

import java.util.Stack;

public class LargestRectangle_Histogram {
	public int largestRectangleArea(int[] heights) {
		int len = heights.length;
		Stack<Integer> stack = new Stack<Integer>();
		int maxArea = 0;
		for (int i = 0; i <= len; i++) {
			int h = (i == len ? 0 : heights[i]);
			if (stack.isEmpty() || h > heights[stack.peek()]) {
				stack.push(i);
			} else {
				int top = stack.pop();
				maxArea = Math.max(maxArea, heights[top] * (stack.isEmpty() ? i : i - 1 - stack.peek()));
				i--;
			}

		}
		return maxArea;
	}
}
