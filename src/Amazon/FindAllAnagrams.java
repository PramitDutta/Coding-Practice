package Amazon;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagrams {
	public static List<Integer> allAnagrams(String s, String p) {
		List<Integer> list = new ArrayList<Integer>();
		int[] chars = new int[26];
		if (p.length() > s.length() || s == null || p == null)
			return list;
		for (char c : p.toCharArray()) {
			chars[c - 'a']++;
		}
		int start = 0, end = 0, counter = p.length();
		while (end < s.length()) {
			// end character exists in p's array so decrease the counter;
			// >=1 means it is existing in p
			if (chars[s.charAt(end++) - 'a']-- >= 1)
				counter--;
			// when count is 0 means we found the anagram
			if (counter == 0)
				list.add(start);
			// if window size is equal to p and move start to find new match
			// ++ to reset the chars array because we kicked out the start
			// only increase count if character is in p
			// >=0 indicates it was original in the chars array, as it wont go
			// below 0
			if (end - start == p.length() && chars[s.charAt(start++) - 'a']++ >= 0)
				counter++;
		}
		return list;

	}
}
