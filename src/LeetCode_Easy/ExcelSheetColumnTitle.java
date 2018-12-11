package LeetCode_Easy;

public class ExcelSheetColumnTitle {
	public String convertToTitle(int n) {
		if (n <= 0) {
			throw new IllegalArgumentException("Input is not valid!");
		}

		StringBuilder sb = new StringBuilder();

		// The key is n--. The minimum in 26-bit number is mapped to 1, not 0.

		while (n > 0) {
			n--;
			char ch = (char) (n % 26 + 'A');
			n /= 26;
			sb.append(ch);
		}

		sb.reverse();
		return sb.toString();
	}
}
