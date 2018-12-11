package Amazon;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	public static int[] pairs(int[] arr, int target) {
		int[] result = new int[2];
		if (arr == null || arr.length < 2)
			return result;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(target - arr[i])) {
				result[1] = i;
				result[0] = map.get(target - arr[i]);
			} else
				map.put(arr[i], i);
		}
		return result;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 4, 3, 11, 9, 5 };
		int[] pairs = pairs(nums, 10);
		System.out.println(pairs[0] + "," + pairs[1]);
	}

}
