package LeetCode_Medium;

import java.util.Arrays;

/*Arrays.binarySearch() returns index of the search key, if it is contained in the array, else returns (-(insertion point) - 1). 
 * The insertion point is the point at which the key would be inserted into the array: the index of the first element greater than 
 * the key, or a.length if all elements in the array are less than the specified key.*/

public class LIS_Length {
	public int lengthOfLIS(int[] nums) {
		int[] dp = new int[nums.length];
		int len = 0;

		for (int n : nums) {
			int i = Arrays.binarySearch(dp, 0, len, n); // time complexity --
														// O(nlogn)
			if (i < 0) {
				i = -(i + 1);
			}
			dp[i] = n;
			if (i == len) {
				len++;
			}
		}
		return len;
	}

	public int lisLength(int[] nums) {
		if (nums.length == 0)
			return 0;

		int[] dp = new int[nums.length];
		dp[0] = 1;
		int max = 1;
		for (int i = 1; i < dp.length; i++) {
			int maxval = 0;
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					maxval = Math.max(maxval, dp[j]);
				}
			}
			dp[i] = maxval + 1;
			max = Math.max(max, dp[i]);
		}
		return max;
	}
}
