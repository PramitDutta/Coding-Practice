package LeetCode_Medium;

import java.util.SortedSet;
import java.util.TreeSet;

public class ContainsDuplicateIII {
	public boolean containsDup(int[] nums, int t, int k) {
		if (nums == null || nums.length < 2 || k < 0 || t < 0)
			return false;

		TreeSet<Integer> set = new TreeSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			int curr = nums[i];

			int leftBoundary = curr - t;
			int rightBoundary = curr + t + 1;

			SortedSet<Integer> sub = set.subSet(leftBoundary, rightBoundary);
			if (sub.size() > 0)
				return true;

			set.add(curr);

			if (i >= k) {
				set.remove(nums[i - k]);
			}
		}
		return false;
	}
}
