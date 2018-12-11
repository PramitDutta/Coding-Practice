package LeetCode_hard;

public class FirstMissingPositive {
	public static int firstMissingPositive(int[] A) {
		int i = 0;
		while (i < A.length) {
			if (A[i] == i + 1 || A[i] <= 0 || A[i] > A.length)
				i++;
			else if (A[A[i] - 1] != A[i])
				swap(A, i, A[i] - 1);
			else
				i++;
		}
		i = 0;
		while (i < A.length && A[i] == i + 1)
			i++;
		return i + 1;
	}

	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {
		int[] nums = { 3, 4, -1, 1 };
		int result = firstMissingPositive(nums);
		System.out.println(result);
	}
}
