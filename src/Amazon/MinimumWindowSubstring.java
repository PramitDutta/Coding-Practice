package Amazon;

public class MinimumWindowSubstring {
	public static String minWindow(String s, String t) {
		int[] hash = new int[256];
		char[] S = s.toCharArray();
		char[] T = t.toCharArray();
		for (int i = 0; i < T.length; i++) {
			hash[T[i]]++;
		}
		int counter = T.length, begin = 0, end = 0, head = 0;
		int min = Integer.MAX_VALUE;

		while (end < S.length) {
			if (hash[S[end++]]-- > 0) {
				counter--;
			}
			while (counter == 0) {
				if (min > end - begin) {
					min = end - begin;
					head = begin;
				}
				if (hash[S[begin++]]++ == 0) {
					counter++;
				}
			}
		}
		return min == Integer.MAX_VALUE ? "" : s.substring(head, head + min);
	}

	public static void main(String[] args) {
		String s = "ADOBECODEBANC";
		String t = "ABC";
		System.out.println(minWindow(s, t));
	}
}
