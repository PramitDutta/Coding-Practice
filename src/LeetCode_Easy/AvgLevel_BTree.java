package LeetCode_Easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AvgLevel_BTree {
	public List<Double> averageOfLevels(TreeNode root) {
		List<Double> list = new ArrayList<Double>();
		if (root == null)
			return list;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int levelNum = queue.size();
			double sum = 0.0;
			for (int i = 0; i < levelNum; i++) {
				TreeNode node = queue.poll();
				sum += node.val;
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
			}
			list.add(sum / levelNum);
		}
		return list;
	}
}
