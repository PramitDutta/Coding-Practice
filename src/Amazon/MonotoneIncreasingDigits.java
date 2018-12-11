package Amazon;

public class MonotoneIncreasingDigits {
	public int monotone(int num) {
		if (num <= 9)
			return num;
		char[] n = String.valueOf(num).toCharArray();

		int limit = n.length;
		for (int i = n.length - 1; i > 0; i--) {
			if (n[i] < n[i - 1]) {
				limit = i - 1;
				n[i - 1]--;
			}
		}
		for (int i = limit + 1; i < n.length; i++) {
			n[i] = '9';
		}
		return Integer.parseInt(new String(n));
	}
}
