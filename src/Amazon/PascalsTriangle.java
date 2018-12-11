package Amazon;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
	public List<List<Integer>> pascals(int n) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (n <= 0)
			return result;

		List<Integer> pre = new ArrayList<Integer>();
		pre.add(1);
		result.add(pre);

		for (int i = 2; i <= n; i++) {
			List<Integer> cur = new ArrayList<Integer>();
			cur.add(1);
			for (int j = 0; j < pre.size() - 1; j++) {
				cur.add(pre.get(j) + pre.get(j + 1));
			}
			cur.add(1);

			result.add(cur);
			pre = cur;
		}
		return result;
	}

	public List<Integer> nthPascalRow(int n) {
		List<Integer> result = new ArrayList<Integer>();
		if (n <= 0)
			return result;
		for (int i = 0; i < n + 1; i++) {
			result.add(0, 1);
			for (int j = 1; j < result.size() - 1; j++) {
				result.set(j, result.get(j) + result.get(j + 1));
			}
		}
		return result;
	}

	public int pascalIndex(int x, int y) {
		if (x == 1 || y == 1 || x == y)
			return 1;
		else
			return pascalIndex(x - 1, y - 1) + pascalIndex(x - 1, y);
	}
}
