package Test;

public class BinarySearch {
	public static boolean isPresent(int[] arr, int k) {
		int low = 0, high = arr.length - 1;
		if (high >= low) {
			int mid = low + (high - low) / 2;
			if (arr[mid] == k)
				return true;
			else if (arr[mid] > k)
				high = mid - 1;
			else
				low = mid + 1;
		}
		return false;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 4, 3, 6, 8, 9, 10 };
		System.out.println(isPresent(arr, 7));
	}
}
