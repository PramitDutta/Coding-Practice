package Amazon;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// Time Complexity --> O(E+NlogN) where E is the total number of flights
// Space Complexity --> O(n), the size of the heap

public class CheapestFlight {
	public int findCheapest(int n, int[][] flights, int src, int dst, int K) {
		int[][] graph = new int[n][n];
		for (int[] flight : flights) {
			graph[flight[0]][flight[1]] = flight[2];
		}
		Map<int[], Integer> best = new HashMap<>();
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
		pq.offer(new int[] { 0, 0, src });
		while (!pq.isEmpty()) {
			int[] info = pq.poll();
			int cost = info[0], k = info[1], place = info[2];
			if (k > K + 1 || cost > best.getOrDefault(new int[] { k, place }, Integer.MAX_VALUE))
				continue;
			if (place == dst)
				return cost;
			for (int nei = 0; nei < n; nei++) {
				if (graph[place][nei] > 0) {
					int newCost = cost + graph[place][nei];
					if (newCost < best.getOrDefault(new int[] { k + 1, nei }, Integer.MAX_VALUE)) {
						pq.offer(new int[] { newCost, k + 1, nei });
						best.put(new int[] { k + 1, nei }, newCost);
					}
				}
			}
		}
		return -1;
	}
}
