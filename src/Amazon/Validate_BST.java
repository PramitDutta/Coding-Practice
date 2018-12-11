package Amazon;

import java.util.Stack;

import LeetCode_Easy.TreeNode;

public class Validate_BST {
	public static boolean validBST(TreeNode root) {
		if (root == null)
			return true;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode pre = null;
		while (!stack.isEmpty() || root != null) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			if (pre != null && pre.val >= root.val)
				return false;
			pre = root;
			root = root.right;
		}
		return true;
	}

	public static void main(String[] args) {
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(8);
		TreeNode d = new TreeNode(4);
		TreeNode e = new TreeNode(5);
		TreeNode f = new TreeNode(6);
		TreeNode g = new TreeNode(7);
		d.left = b;
		d.right = f;
		b.left = a;
		b.right = c;
		f.left = e;
		f.right = g;
		System.out.println(validBST(d));
	}
}
