package Amazon;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class CutOffTrees {
	int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	public int cutOffTree(List<List<Integer>> forest) {
		if (forest == null || forest.size() == 0 || forest.get(0).size() == 0) {
			return 0;
		}
		int r = forest.size();
		int c = forest.get(0).size();

		PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((a, b) -> a[2] - b[2]);
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (forest.get(i).get(j) > 1) {
					minHeap.add(new int[] { i, j, forest.get(i).get(j) });
				}
			}
		}

		int[] start = new int[2];
		int res = 0;
		while (!minHeap.isEmpty()) {
			int[] lowest = minHeap.poll();
			int step = minStep(forest, start, lowest, r, c);
			if (step < 0) {
				return -1;
			}
			res += step;
			start[0] = lowest[0];
			start[1] = lowest[1];
		}
		return res;
	}

	private int minStep(List<List<Integer>> forest, int[] start, int[] lowest, int r, int c) {
		int step = 0;
		LinkedList<int[]> que = new LinkedList<int[]>();
		boolean[][] used = new boolean[r][c];

		que.add(start);
		used[start[0]][start[1]] = true;
		while (!que.isEmpty()) {
			int size = que.size();
			for (int i = 0; i < size; i++) {
				int[] cur = que.poll();
				if (cur[0] == lowest[0] && cur[1] == lowest[1]) {
					return step;
				}
				for (int[] dir : dirs) {
					int nx = cur[0] + dir[0];
					int ny = cur[1] + dir[1];
					if (nx < 0 || nx >= r || ny < 0 || ny >= c || used[nx][ny] || forest.get(nx).get(ny) == 0) {
						continue;
					}
					que.add(new int[] { nx, ny });
					used[nx][ny] = true;
				}
			}
			step++;
		}
		return -1;
	}
}
