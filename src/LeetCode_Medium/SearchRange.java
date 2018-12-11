package LeetCode_Medium;

public class SearchRange {
	public static int[] searchRange(int[] nums, int target) {
		int[] result = new int[2];
		if (nums == null || nums.length == 0)
			return result;

		int upper = upperOrLower(nums, target, true);
		int lower = upperOrLower(nums, target, false);

		result[0] = lower;
		result[1] = upper;

		return result;
	}

	private static int upperOrLower(int[] nums, int target, boolean upper) {
		int left = 0, right = nums.length - 1;
		int res = -1;
		int mid;
		while (left <= right) {
			mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				res = mid;
				if (upper)
					left = mid + 1;
				else
					right = mid - 1;
			} else if (nums[mid] > target)
				right = mid - 1;
			else
				left = mid + 1;
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 5, 7, 7, 8, 8, 10 };
		int[] result = searchRange(nums, 8);
		for (int i : result) {
			System.out.print(i + " ");
		}
	}

}
