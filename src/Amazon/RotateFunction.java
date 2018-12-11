package Amazon;

public class RotateFunction {
	public static int maxRotate(int[] A) {
		if (A.length == 0)
			return 0;
		int sum = 0, F = 0, len = A.length;
		for (int i = 0; i < len; i++) {
			sum += A[i];
			F += (A[i] * i);
		}
		int max = F;
		for (int i = len - 1; i >= 0; i--) {
			F = F + sum - len * A[i];
			max = Math.max(F, max);
		}
		return max;
	}

	public static void main(String[] args) {
		int[] A = { 4, 3, 2, 6 };
		maxRotate(A);
	}

}
