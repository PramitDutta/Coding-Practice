package LeetCode_Medium;

public class Pow_xn {
	public static double pow(double x, int n) {
		if (n == 0)
			return 1;
		if (n < 0) {
			n = -n;
			x = 1 / x;
		}
		return (n % 2 == 0) ? pow(x * x, n / 2) : x * pow(x * x, n / 2);
	}

	public static void main(String[] args) {
		double result = pow(3, -4);
		System.out.println(result);
	}
}
