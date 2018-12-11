package Amazon;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationOfAPhoneNumber {
	public static List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<String>();
		if (digits == null)
			return result;

		String[] dict = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		StringBuilder sb = new StringBuilder();
		helper(digits, 0, sb, dict, result);

		return result;
	}

	private static void helper(String digits, int start, StringBuilder sb, String[] dict, List<String> result) {
		if (start >= digits.length()) {
			result.add(sb.toString());
			return;
		}

		int num = digits.charAt(start) - '0';
		for (int i = 0; i < dict[num].length(); i++) {
			sb.append(dict[num].charAt(i));
			helper(digits, start + 1, sb, dict, result);
			sb.deleteCharAt(sb.length() - 1);
		}
	}

	public static void main(String[] args) {
		String digits = "123";
		List<String> list = letterCombinations(digits);
		System.out.println(list);
	}
}
