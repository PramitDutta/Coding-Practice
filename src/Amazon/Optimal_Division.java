package Amazon;

public class Optimal_Division {
	public String optimalDivision(int[] nums) {
		if (nums.length == 1)
			return nums[0] + "";
		if (nums.length == 2)
			return nums[0] + "/" + nums[1];
		String res = nums[0] + "/(" + nums[1];
		for (int i = 2; i < nums.length; i++) {
			res += "/" + nums[i];
		}
		return res + ")";
	}
}
