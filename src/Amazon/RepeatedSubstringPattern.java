package Amazon;

public class RepeatedSubstringPattern {
	public static boolean repeatedSubStrPattern(String s) {
		int n = s.length();
		for (int i = n / 2; i >= 1; i--) {
			if (n % i == 0) {
				int m = n / i;
				String subS = s.substring(0, i);
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < m; j++) {
					sb.append(subS);
				}
				if (sb.toString().equals(s))
					return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		String s = "abcabcabcd";
		boolean result = repeatedSubStrPattern(s);
		System.out.println(result);
	}
}
