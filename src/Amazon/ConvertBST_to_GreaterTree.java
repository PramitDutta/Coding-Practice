package Amazon;

import LeetCode_Easy.TreeNode;

public class ConvertBST_to_GreaterTree {
	static int sum = 0;

	public static TreeNode convertBST(TreeNode root) {
		if (root == null)
			return null;
		convertBST(root.right);
		root.val += sum;
		sum = root.val;
		convertBST(root.left);
		return root;
	}

	public static void main(String[] args) {
		TreeNode a = new TreeNode(5);
		TreeNode b = new TreeNode(13);
		TreeNode c = new TreeNode(2);
		a.left = c;
		a.right = b;
		TreeNode root = convertBST(a);
		System.out.println(root.val + " " + root.left.val + " " + root.right.val);
	}

}
