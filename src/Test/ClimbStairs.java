package Test;

public class ClimbStairs {
	public static int climbStairs(int n) {
		if (n == 0 || n == 1 || n == 2)
			return n;
		int[] dp = new int[n + 1];
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
	}

	public static void main(String[] args) {
		int result = climbStairs(3);
		System.out.println(result);
	}
}