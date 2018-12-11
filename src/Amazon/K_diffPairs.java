package Amazon;

import java.util.HashMap;
import java.util.Map;

public class K_diffPairs {
	public static int findPairs(int[] nums, int k) {
		if (nums == null || nums.length == 0 || k < 0)
			return 0;
		Map<Integer, Integer> map = new HashMap<>();
		int count = 0;
		for (int i : nums) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (k == 0) {
				if (entry.getValue() >= 2)
					count++;
			} else {
				if (map.containsKey(entry.getKey() + k))
					count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5 };
		int k = 1;
		int result = findPairs(nums, k);
		System.out.println(result);
	}
}
