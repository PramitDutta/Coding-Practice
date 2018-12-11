package LeetCode_Easy;

public class Subtree_AnotherTree {
	public boolean isSubTree(TreeNode s, TreeNode t) {
		if (s == null)
			return false;
		if (isSame(s, t))
			return true;
		return isSubTree(s.left, t) || isSubTree(s.right, t);
	}

	private boolean isSame(TreeNode s, TreeNode t) {
		if (s == null && t == null)
			return true;
		if (s == null || t == null)
			return false;
		if (s.val != t.val)
			return false;
		return isSame(s.left, t.left) && isSame(s.right, t.right);
	}
}
