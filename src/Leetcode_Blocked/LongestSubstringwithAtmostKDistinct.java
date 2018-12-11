package Leetcode_Blocked;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringwithAtmostKDistinct {
	public static int longSubWithAtmost(String s, int k) {
		Map<Character, Integer> map = new HashMap<>();
		int start = 0, end = 0, len = 0, counter = 0;
		while (end < s.length()) {
			char c = s.charAt(end);
			map.put(c, map.getOrDefault(c, 0) + 1);
			if (map.get(c) == 1)
				counter++;
			end++;

			while (counter > k) {
				char temp = s.charAt(start);
				map.put(temp, map.get(temp) - 1);
				if (map.get(temp) == 0)
					counter--;
				start++;
			}
			len = Math.max(len, end - start);
		}
		return len;
	}

	public static void main(String[] args) {
		String s = "aabbbacdacbbbbcbaaaaa";
		int result = longSubWithAtmost(s, 3);
		System.out.println(result);
	}
}
