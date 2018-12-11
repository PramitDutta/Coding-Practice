package Amazon;

public class NearestNode {
	public TreeNode findNearestNode(int val, TreeNode root) {
		if (root == null)
			return null;
		int dis = Integer.MAX_VALUE, i = 0;
		TreeNode nearestNode = root;
		TreeNode temp = root;
		while (temp != null) {

			if (val == temp.val) {
				nearestNode = temp;
				break;
			}

			i = Math.abs(temp.val - val);

			if (dis > i) {
				dis = i;
				nearestNode = temp;
			}
			if (val > temp.val) {
				temp = temp.right;
			} else {
				temp = temp.left;
			}

		}
		return nearestNode;
	}
}
