package DynamicProgramming;

public class TrappingRainWater {
	public static int trap(int[] height) {
		if (height == null)
			return 0;
		int result = 0;
		int n = height.length;
		int[] left_max = new int[n];
		int[] right_max = new int[n];
		left_max[0] = height[0];
		right_max[n - 1] = height[n - 1];

		for (int i = 1; i < n; i++) {
			left_max[i] = Math.max(height[i], left_max[i - 1]);
		}
		for (int i = n - 2; i >= 0; i--) {
			right_max[i] = Math.max(height[i], right_max[i + 1]);
		}

		for (int i = 1; i < n - 1; i++) {
			result += Math.min(left_max[i], right_max[i]) - height[i];
		}
		return result;
	}

	public static void main(String[] args) {
		int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.println(trap(height));
	}
}
