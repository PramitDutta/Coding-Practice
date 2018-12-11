package LeetCode_Easy;

public class MinimumAbsoluteDifferenceBST {
	int min = Integer.MAX_VALUE;
	Integer prev = null;

	public int minAbsDiff(TreeNode root) {
		if (root == null)
			return min;
		minAbsDiff(root.left);
		if (prev != null) {
			min = Math.min(min, root.val - prev);
		}
		prev = root.val;
		minAbsDiff(root.right);

		return min;
	}
}
