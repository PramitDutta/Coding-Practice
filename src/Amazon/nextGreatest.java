package Amazon;

public class nextGreatest {
	public static void nextGreat(int nums[]) {
		int n = nums.length;
		int max = nums[n - 1];
		nums[n - 1] = -1;
		for (int i = n - 2; i >= 0; i--) {
			int temp = nums[i];
			nums[i] = max;
			if (max < temp) {
				max = temp;
			}
		}
	}

	public static void main(String[] args) {
		int[] nums = { 16, 17, 4, 3, 5, 2 };
		nextGreat(nums);
		for (int i : nums) {
			System.out.print(i + " ");
		}
	}
}
