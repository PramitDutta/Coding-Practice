package Amazon;
/* dp(i, j) represents whether s(i ... j) can form a palindromic substring, 
 * dp(i, j) is true when s(i) equals to s(j) and s(i+1 ... j-1) is a palindromic substring. 
 * When we found a palindrome, check if it's the longest one. Time complexity O(n^2).*/

public class LongestPalindromicSubstring {
	public static String longestPalindrome(String s) {
		int n = s.length();
		String result = null;

		boolean[][] dp = new boolean[n][n];
		for (int i = n - 1; i >= 0; i--) {
			for (int j = i; j < n; j++) {
				dp[i][j] = (s.charAt(i) == s.charAt(j)) && (j - i < 3 || dp[i + 1][j - 1]);
				if (dp[i][j] && (result == null || j - i + 1 > result.length())) {
					result = s.substring(i, j + 1);
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		String str = "babad";
		System.out.println(longestPalindrome(str));
	}
}
