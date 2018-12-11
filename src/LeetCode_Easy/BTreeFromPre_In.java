package LeetCode_Easy;

public class BTreeFromPre_In {
	public TreeNode buildTree(int[] preOrder, int[] inOrder) {
		return helper(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);
	}

	public TreeNode helper(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd) {
		if (preStart > preEnd || inStart > inEnd)
			return null;

		int val = preOrder[preStart];
		TreeNode p = new TreeNode(val);

		int k = 0;
		for (int i = 0; i < inOrder.length; i++) {
			if (val == inOrder[i]) {
				k = i;
				break;
			}
		}
		p.left = helper(preOrder, preStart + 1, preStart + (k - inStart), inOrder, inStart, k - 1);
		p.right = helper(preOrder, preStart + (k - inStart) + 1, preEnd, inOrder, k + 1, inEnd);

		return p;
	}

}
