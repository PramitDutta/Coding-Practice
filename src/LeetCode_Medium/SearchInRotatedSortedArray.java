package LeetCode_Medium;

public class SearchInRotatedSortedArray {
	public boolean search(int[] nums, int target) {
		int start = 0, end = nums.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (nums[mid] == target)
				return true;

			if (nums[mid] < nums[end] || nums[mid] < nums[start]) {
				if (target > nums[mid] && target <= nums[end]) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			} else if (nums[start] < nums[mid] || nums[mid] > nums[end]) {
				if (target >= nums[start] && target < nums[mid]) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			} else {
				start++;
			}
		}
		return false;
	}
}
