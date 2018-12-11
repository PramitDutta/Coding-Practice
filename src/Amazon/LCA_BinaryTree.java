package Amazon;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import LeetCode_Easy.TreeNode;

public class LCA_BinaryTree {
	public TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
		Map<TreeNode, TreeNode> parent = new HashMap<>();
		Deque<TreeNode> stack = new ArrayDeque<>();
		parent.put(root, null);
		stack.push(root);

		while (!parent.containsKey(p) || !parent.containsKey(q)) {
			TreeNode node = stack.pop();
			if (node.left != null) {
				parent.put(node.left, node);
				stack.push(node.left);
			}
			if (node.right != null) {
				parent.put(node.right, node);
				stack.push(node.right);
			}
		}
		// after p and q is found we create a set of p's ancestors.
		// then we travel through q's ancestors. the first common is the LCA
		Set<TreeNode> ancestors = new HashSet<>();
		while (p != null) {
			ancestors.add(p);
			p = parent.get(p);
		}
		while (!ancestors.contains(q)) {
			q = parent.get(q);
		}
		return q;
	}
}
