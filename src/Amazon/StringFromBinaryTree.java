package Amazon;

import LeetCode_Easy.TreeNode;

public class StringFromBinaryTree {
	public static String tree2str(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		helper(sb, root);
		return sb.toString();
	}

	public static void helper(StringBuilder sb, TreeNode root) {
		if (root != null) {
			sb.append(root.val);
			if (root.left != null || root.right != null) {
				sb.append("(");
				helper(sb, root.left);
				sb.append(")");
				if (root.right != null) {
					sb.append("(");
					helper(sb, root.right);
					sb.append(")");
				}
			}
		}
	}
}
