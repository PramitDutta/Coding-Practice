package LeetCode_Medium;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringWithAtleastKChars {
	public static int longestSubstring(String s, int k) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		HashSet<Character> splitSet = new HashSet<Character>();
		for (char c : map.keySet()) {
			if (map.get(c) < k)
				splitSet.add(c);
		}

		if (splitSet.isEmpty())
			return s.length();

		int max = 0;
		int i = 0, j = 0;
		while (j < s.length()) {
			char c = s.charAt(j);
			if (splitSet.contains(c)) {
				if (j != i) {
					max = Math.max(max, longestSubstring(s.substring(i, j), k));
				}
				i = j + 1;
			}
			j++;
		}
		if (i != j)
			max = Math.max(max, longestSubstring(s.substring(i, j), k));

		return max;
	}

	public static void main(String[] args) {
		String s = "aaabbaa";
		int k = 3;
		int result = longestSubstring(s, k);
		System.out.println(result);
	}
}
