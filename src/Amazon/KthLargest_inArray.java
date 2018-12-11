package Amazon;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargest_inArray {
	public static int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});

		for (int n : nums)
			pq.offer(n);

		int top = 0;
		while (k > 0) {
			top = pq.poll();
			k--;
		}
		return top;
	}

	public static int[] findKLargest(int[] nums, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k);
		for (int n : nums) {
			pq.offer(n);

			if (pq.size() > k) {
				pq.poll();
			}
		}
		int[] result = new int[k];
		for (int i = k - 1; i >= 0; i--) {
			result[i] = pq.poll();
		}
		return result;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 3, 5, 4, 9, 7, 2, 8, 12, 11, 17 };
		int result = findKthLargest(arr, 3);

		int[] topK = findKLargest(arr, 5);
		System.out.println(result);
		for (int i : topK) {
			System.out.print(i + ", ");
		}
	}
}
