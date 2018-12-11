
package Amazon;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMax {
	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums.length == 0 || nums == null || k <= 0)
			return new int[0];

		int[] result = new int[nums.length - k + 1];
		Deque<Integer> deque = new LinkedList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			while (!deque.isEmpty() && nums[i] > nums[deque.getLast()]) {
				deque.removeLast();
			}
			deque.addLast(i);

			if (i - deque.getFirst() + 1 > k)
				deque.removeFirst();

			if (i + 1 >= k)
				result[i + 1 - k] = nums[deque.getFirst()];

		}
		return result;
	}
}
