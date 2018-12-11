package Amazon;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class ThirdMaximum {
	public static int thirdMax(int[] nums) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		Set<Integer> set = new HashSet<>();
		for (int i : nums) {
			if (!set.contains(i)) {
				pq.offer(i);
				set.add(i);
				if (pq.size() > 3) {
					set.remove(pq.poll());
				}
			}
		}
		if (pq.size() < 3) {
			while (pq.size() > 1) {
				pq.poll();
			}
		}
		return pq.peek();
	}

	public static void main(String[] args) {
		int[] nums = { 4, 7, 3, 8, 9 };
		int result = thirdMax(nums);
		System.out.println(result);
	}
}
