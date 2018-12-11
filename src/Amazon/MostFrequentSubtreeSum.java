package Amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import LeetCode_Easy.TreeNode;

public class MostFrequentSubtreeSum {
	int max = 0;

	public int[] findFreqSubtreeSum(TreeNode root) {
		if (root == null)
			return new int[0];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		helper(root, map);
		List<Integer> list = new ArrayList<Integer>();
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() == max) {
				list.add(entry.getKey());
			}
		}
		return list.stream().mapToInt(i -> i).toArray();

	}

	private int helper(TreeNode node, Map<Integer, Integer> map) {
		int left = (node.left == null) ? 0 : helper(node.left, map);
		int right = (node.right == null) ? 0 : helper(node.right, map);
		int sum = left + right + node.val;
		map.put(sum, map.getOrDefault(sum, 0) + 1);
		max = Math.max(max, map.get(sum));
		return sum;
	}
}
