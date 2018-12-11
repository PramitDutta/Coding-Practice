package LeetCode_Medium;

import java.util.PriorityQueue;

public class KthSmallestInMatrix {
	public static int kthSmallest(int[][] matrix, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				pq.offer(matrix[i][j]);
			}
		}
		for (int j = 0; j < k - 1; j++) {
			pq.poll();
		}
		return pq.peek();
	}

	public static int kthSmallest_V1(int[][] matrix, int k) {
		int m = matrix.length;
		int lower = matrix[0][0];
		int upper = matrix[m - 1][m - 1];

		while (lower < upper) {
			int mid = lower + (upper - lower) / 2;
			int count = count(matrix, mid);
			if (count < k) {
				lower = mid + 1;
			} else {
				upper = mid;
			}
		}
		return upper;
	}

	private static int count(int[][] matrix, int target) {
		int m = matrix.length;
		int i = m - 1;
		int j = 0;
		int count = 0;
		while (i >= 0 && j < m) {
			if (matrix[i][j] <= target) {
				count += i + 1;
				j++;
			} else {
				i--;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 5, 9 }, { 10, 11, 13 }, { 12, 13, 15 } };
		int result = kthSmallest(matrix, 7);
		System.out.println(result);

	}
}
