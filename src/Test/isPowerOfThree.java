package Test;

public class isPowerOfThree {
	public static boolean isPowThree(int n) {
		double x = Math.round(Math.log(n) / Math.log(3));
		double val = Math.pow(3, x);
		if (val == n)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		int n = 19;
		System.out.println(isPowThree(n));
	}
}
