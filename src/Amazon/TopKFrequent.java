package Amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequent {
	public static List<Integer> topKFreq(int[] nums, int k) {
		@SuppressWarnings("unchecked")
		List<Integer>[] bucket = new List[nums.length + 1];
		Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
		for (int n : nums) {
			freqMap.put(n, freqMap.getOrDefault(n, 0) + 1);
		}

		for (int key : freqMap.keySet()) {
			int frequency = freqMap.get(key);
			if (bucket[frequency] == null) {
				bucket[frequency] = new ArrayList<>();
			}
			bucket[frequency].add(key);
		}

		List<Integer> res = new ArrayList<>();
		for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
			if (bucket[pos] != null) {
				res.addAll(bucket[pos]);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 3, 1, 2, 4, 3, 5, 3, 5, 7, 5, 4, 5, 2, 2, 8, 5, 3 };
		int k = 2;
		List<Integer> list = topKFreq(nums, k);
		for (int e : list) {
			System.out.print(e + " ");
		}
	}
}
