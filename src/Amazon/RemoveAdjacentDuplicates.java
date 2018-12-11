package Amazon;

public class RemoveAdjacentDuplicates {
	public static String solve(String str) {
		StringBuilder result = new StringBuilder();
		int i = 0;
		while (i < str.length()) {
			// if char at position i is identical to the last character we have
			// seen
			if (result.length() > 0 && str.charAt(i) == result.charAt(result.length() - 1)) {
				i++;
				while (i < str.length() && str.charAt(i) == result.charAt(result.length() - 1)) {
					i++;
				}
				result.deleteCharAt(result.length() - 1);
			} else {
				result.append(str.charAt(i));
				i++;
			}
		}
		return result.toString();
	}

	public static void main(String[] args) {
		String in = "bottom";
		String out = solve(in);
		System.out.println(out);
	}
}
