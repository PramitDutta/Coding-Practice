package LeetCode_Medium;

public class IncreasingTripletSubSequence {
	public static boolean increasingTriplet(int[] nums) {
		int x = Integer.MAX_VALUE;
		int y = Integer.MAX_VALUE;

		for (int i = 0; i < nums.length; i++) {
			int z = nums[i];
			if (x >= z) {
				x = z;
			} else if (y >= z) {
				y = z;
			} else {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[] nums = { 6, 5, 3, 4, 2 };
		System.out.println(increasingTriplet(nums));
	}
}
