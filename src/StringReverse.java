
public class StringReverse {
	public static String Reverse(String s) {
		char[] c = s.toCharArray();
		int start = 0, end = s.length() - 1;
		while (start < end) {
			char temp = c[start];
			c[start] = c[end];
			c[end] = temp;
			start++;
			end--;
		}
		return new String(c);
	}

	public static void main(String args[]) {
		String input = "Hello";
		System.out.println(Reverse(input));
	}
}
