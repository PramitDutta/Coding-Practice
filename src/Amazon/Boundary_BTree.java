package Amazon;

import java.util.ArrayList;
import java.util.List;

import LeetCode_Easy.TreeNode;

public class Boundary_BTree {
	public void DFS(TreeNode node, List<Integer> list) {
		if (node != null) {
			if (node.left == null && node.right == null)
				list.add(node.val);
			else {
				DFS(node.left, list);
				DFS(node.right, list);
			}
		}
	}

	public void getLeftPath(TreeNode left, List<Integer> list) {
		if (left != null) {
			list.add(left.val);
			if (left.left != null) {
				getLeftPath(left.left, list);
				DFS(left.right, list);
			} else {
				getLeftPath(left.right, list);
			}
		}
	}

	public void getRightPath(TreeNode right, List<Integer> list) {
		if (right != null) {
			if (right.right != null) {
				DFS(right.left, list);
				getRightPath(right.right, list);
			} else {
				getRightPath(right.left, list);
			}
			list.add(right.val);
		}
	}

	public List<Integer> boundaryTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		if (root == null)
			return list;
		list.add(root.val);
		getLeftPath(root.left, list);
		getRightPath(root.right, list);

		return list;
	}
}
