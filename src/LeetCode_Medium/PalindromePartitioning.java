package LeetCode_Medium;

import java.util.ArrayList;
import java.util.List;
/* we use a 2d array to keep track of any string we have scanned so far, with an addition pair, 
 * we can determine whether it's palindrome or not by justing looking at that pair, 
 * which is this line if(s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j+1][i-1])). 
 * This way, the 2d array dp contains the possible palindrome partition among all.*/

public class PalindromePartitioning {
	public List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<List<String>>();
		boolean[][] dp = new boolean[s.length()][s.length()];
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j <= i; j++) {
				if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j + 1][i - 1])) {
					dp[j][i] = true;
				}
			}
		}
		helper(result, new ArrayList<>(), dp, s, 0);
		return result;
	}

	private void helper(List<List<String>> result, List<String> part, boolean[][] dp, String s, int pos) {
		if (pos == s.length()) {
			result.add(new ArrayList<>(part));
			return;
		}
		for (int i = 0; i < s.length(); i++) {
			if (dp[pos][i]) {
				part.add(s.substring(pos, i + 1));
				helper(result, part, dp, s, i + 1);
				part.remove(part.size() - 1);
			}
		}
	}
}
