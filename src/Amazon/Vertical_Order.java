package Amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import LeetCode_Easy.TreeNode;

public class Vertical_Order {
	public static List<List<Integer>> verticalOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null)
			return result;

		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		Queue<Integer> level = new LinkedList<Integer>();

		queue.offer(root);
		level.offer(0);

		int minLevel = 0;
		int maxLevel = 0;

		while (!queue.isEmpty()) {
			TreeNode n = queue.poll();
			int lvl = level.poll();

			minLevel = Math.min(minLevel, lvl);
			maxLevel = Math.max(maxLevel, lvl);
			if (map.containsKey(lvl)) {
				map.get(lvl).add(n.val);
			} else {
				ArrayList<Integer> list = new ArrayList<Integer>();
				list.add(n.val);
				map.put(lvl, list);
			}
			if (n.left != null) {
				queue.offer(n.left);
				level.offer(lvl - 1);
			}
			if (n.right != null) {
				queue.offer(n.right);
				level.offer(lvl + 1);
			}
		}
		for (int i = minLevel; i <= maxLevel; i++) {
			if (map.containsKey(i)) {
				result.add(map.get(i));
			}

		}
		return result;
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
		List<List<Integer>> result = verticalOrder(a);
		System.out.println(result);

	}
}
