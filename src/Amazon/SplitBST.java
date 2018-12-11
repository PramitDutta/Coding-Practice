package Amazon;

public class SplitBST {
	public static TreeNode[] splitBST(TreeNode root, int V) {
		TreeNode dummySm = new TreeNode(0);
		TreeNode curSm = dummySm;
		TreeNode dummyLg = new TreeNode(0);
		TreeNode curLg = dummyLg;

		while (root != null) {
			if (root.val <= V) {
				curSm.right = root;
				curSm = root;
				TreeNode tmp = root.right;
				root.right = null;
				root = tmp;
			} else {
				curLg.left = root;
				curLg = root;
				TreeNode tmp = root.left;
				root.left = null;
				root = tmp;
			}
		}
		return new TreeNode[] { dummySm.right, dummyLg.left };
	}

	public static void main(String[] args) {
		TreeNode a = new TreeNode(4);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(6);
		TreeNode d = new TreeNode(1);
		TreeNode e = new TreeNode(3);
		TreeNode f = new TreeNode(5);
		TreeNode g = new TreeNode(7);
		a.left = b;
		a.left.left = d;
		a.left.right = e;
		a.right = c;
		a.right.left = f;
		a.right.right = g;
		TreeNode[] ans = splitBST(a, 2);
		System.out.println(ans[1].val + " " + ans[0].val);

	}
}
