package LeetCode_Medium;

public class OutputContestMatches {
	public static String findContestMatch(int n) {
		String[] str = new String[n];
		for (int i = 0; i < n; i++) {
			str[i] = String.valueOf(i + 1);
		}
		int left = 0, right = n - 1;
		while (left < right) {
			while (left < right) {
				str[left] = "(" + str[left] + "," + str[right] + ")";
				left++;
				right--;
			}
			left = 0;
		}
		return str[0];
	}

	public static void main(String[] args) {
		int n = 8;
		String out = findContestMatch(n);
		System.out.println(out);
	}
}
