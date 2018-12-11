package LeetCode_Medium;

public class BTreeFromPost_In {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
	}

	public TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
		if (inStart > inEnd || postStart > postEnd)
			return null;

		int rootVal = postorder[postEnd];
		TreeNode root = new TreeNode(rootVal);

		int k = 0;
		for (int i = 0; i <= inEnd; i++) {
			if (inorder[i] == rootVal) {
				k = i;
				break;
			}
		}

		root.left = buildTree(inorder, inStart, k - 1, postorder, postStart, postStart + k - (inStart + 1));
		root.right = buildTree(inorder, k + 1, inEnd, postorder, postStart + k - (inStart + 1) + 1, postEnd - 1);

		return root;
	}
}
