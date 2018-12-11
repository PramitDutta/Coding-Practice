package Amazon;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Serialize_DeSerialize_BinaryTree {
	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		buildString(root, sb);
		return sb.toString();
	}

	private void buildString(TreeNode node, StringBuilder sb) {
		if (node == null) {
			sb.append("X").append(",");
		} else {
			sb.append(node.val).append(",");
			buildString(node.left, sb);
			buildString(node.right, sb);
		}
	}

	private TreeNode getNode(Queue<String> queue) {
		String val = queue.poll();
		if (val.equals("X"))
			return null;
		else {
			TreeNode node = new TreeNode(Integer.valueOf(val));
			node.left = getNode(queue);
			node.right = getNode(queue);
			return node;
		}
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if (data == null)
			return null;
		String[] nodes = data.split(",");
		Deque<String> queue = new LinkedList<>();
		for (String s : nodes) {
			queue.offer(s);
		}
		return getNode(queue);
	}
}
