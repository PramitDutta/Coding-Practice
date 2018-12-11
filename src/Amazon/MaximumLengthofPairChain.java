package Amazon;

import java.util.Arrays;

public class MaximumLengthofPairChain {
	public int findLongestChain(int[][] pairs) {
		Arrays.sort(pairs, (a, b) -> (a[0] - b[0]));
		int max = 0, n = pairs.length;

		int[] dp = new int[n];
		for (int i = 0; i < n; i++) {
			dp[i] = 1;
		}
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (pairs[j][1] < pairs[i][0] && dp[i] < dp[j] + 1)
					dp[i] = dp[j] + 1;
			}
			max = Math.max(max, dp[i]);
		}
		return max;
	}
}
