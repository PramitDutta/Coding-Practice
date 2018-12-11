package Test;

public class MaximumSubArray {
	public static int maxSum(int[] arr) {
		int maxSoFar = arr[0];
		int currMax = arr[0];
		for (int i = 1; i < arr.length; i++) {
			currMax = Math.max(arr[i], currMax + arr[i]);
			maxSoFar = Math.max(maxSoFar, currMax);
		}
		return maxSoFar;
	}

	public static void main(String[] args) {
		int a[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
		int max = maxSum(a);
		System.out.println(max);
	}
}
