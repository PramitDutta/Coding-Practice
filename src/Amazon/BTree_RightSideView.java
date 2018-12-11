package Amazon;

import java.util.ArrayList;
import java.util.List;

import LeetCode_Easy.TreeNode;

public class BTree_RightSideView {
	public static List<Integer> rightSide(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root == null)
			return list;
		rightView(root, list, 0);
		return list;
	}

	public static void rightView(TreeNode node, List<Integer> list, int curDepth) {
		if (node == null)
			return;
		if (curDepth == list.size())
			list.add(node.val);
		rightView(node.right, list, curDepth + 1);
		rightView(node.left, list, curDepth + 1);
	}

	public static void main(String[] args) {
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		TreeNode d = new TreeNode(4);
		TreeNode e = new TreeNode(5);
		a.left = b;
		a.right = c;
		c.right = d;
		b.right = e;
		List<Integer> result = rightSide(a);
		System.out.println(result);
	}
}
