package Amazon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import LeetCode_Easy.TreeNode;

public class Zigzag_LevelOrder {
	public static List<List<Integer>> zigzagOrder(TreeNode root) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		if (root == null)
			return list;
		boolean order = true;
		queue.offer(root);
		while (!queue.isEmpty()) {
			int levelNum = queue.size();
			List<Integer> subList = new ArrayList<Integer>();
			for (int i = 0; i < levelNum; i++) {
				TreeNode n = queue.poll();
				if (order == true)
					subList.add(n.val);
				else
					subList.add(0, n.val);

				if (n.left != null)
					queue.offer(n.left);
				if (n.right != null)
					queue.offer(n.right);
			}
			order = order ? false : true;
			list.add(subList);
		}
		return list;
	}

	public static void main(String[] args) {
		TreeNode a = new TreeNode(3);
		TreeNode b = new TreeNode(9);
		TreeNode c = new TreeNode(20);
		TreeNode d = new TreeNode(15);
		TreeNode e = new TreeNode(7);
		a.left = b;
		a.right = c;
		c.left = d;
		c.right = e;
		List<List<Integer>> result = zigzagOrder(a);
		System.out.println(result);

	}
}
