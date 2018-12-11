package LeetCode_hard;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstring {
	public static String minWindow(String s, String t) {
		if (t.length() > s.length())
			return "";
		Map<Character, Integer> map = new HashMap<>();
		for (char c : t.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		int counter = map.size();
		int begin = 0, end = 0;
		int head = 0;
		int len = Integer.MAX_VALUE;

		while (end < s.length()) {
			char c = s.charAt(end);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) - 1);
				if (map.get(c) == 0)
					counter--;
			}
			end++;

			while (counter == 0) {
				char temp = s.charAt(begin);
				if (map.containsKey(temp)) {
					map.put(temp, map.get(temp) + 1);
					if (map.get(temp) > 0)
						counter++;
				}
				if (end - begin < len) {
					len = end - begin;
					head = begin;
				}
				begin++;
			}
		}
		if (len == Integer.MAX_VALUE)
			return "";
		return s.substring(head, head + len);
	}

	public static void main(String[] args) {
		String s = "ADOBECODEBANC";
		String t = "ABC";
		String min = minWindow(s, t);
		System.out.println(min);
	}
}
