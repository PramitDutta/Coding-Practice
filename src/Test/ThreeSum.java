package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	public List<List<Integer>> threeSums(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums == null || nums.length < 3)
			return result;
		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {
			if (i == 0 || nums[i] > nums[i - 1]) {
				int j = i + 1;
				int k = nums.length - 1;
				while (j < k) {
					if (nums[i] + nums[j] + nums[k] == 0) {
						List<Integer> list = new ArrayList<>();
						list.add(nums[i]);
						list.add(nums[j]);
						list.add(nums[k]);
						result.add(list);
						j++;
						k--;
						while ((j < k) && nums[j] == nums[j - 1]) {
							j++;
						}
						while ((j < k) && nums[k] == nums[k + 1]) {
							k--;
						}
					} else if (nums[i] + nums[j] + nums[k] < 0) {
						j++;
					} else {
						k--;
					}
				}
			}
		}
		return result;
	}
}
