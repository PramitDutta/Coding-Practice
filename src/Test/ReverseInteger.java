package Test;

public class ReverseInteger {
	public static int reverse(int x) {
		int reverse = 0;
		while (x != 0) {
			reverse = reverse * 10 + x % 10;
			x = x / 10;
		}
		return reverse;
	}

	public static void main(String[] args) {
		int num = -123;
		int rev = reverse(num);
		System.out.println(rev);
	}
}
