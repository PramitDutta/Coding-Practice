package Amazon;

public class DuplicateNumber_UsingLL_CycleLogic {
	public static int duplicate(int[] nums) {
		int slow = 0;
		int fast = 0;
		do {
			slow = nums[slow];
			fast = nums[nums[fast]];
		} while (slow != fast);

		int find = 0;
		while (find != slow) {
			slow = nums[slow];
			find = nums[find];
		}
		return find;
	}
}
