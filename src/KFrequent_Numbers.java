import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KFrequent_Numbers {
	public static List<Integer> topKFrequent(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i : nums) {
			if (map.containsKey(i)) {
				map.put(i, map.get(i) + 1);
			} else {
				map.put(i, 1);
			}
		}
		int max = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			max = Math.max(max, entry.getValue());
		}

		ArrayList<Integer>[] arr = new ArrayList[max + 1];
		for (int i = 1; i <= max; i++) {
			arr[i] = new ArrayList<Integer>();
		}

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			int count = entry.getValue();
			int number = entry.getKey();
			arr[count].add(number);
		}

		List<Integer> result = new ArrayList<Integer>();
		for (int j = max; j >= 1; j--) {
			if (arr[j].size() > 0) {
				for (int a : arr[j]) {
					result.add(a);
				}
			}
			if (result.size() == k)
				break;
		}
		return result;
	}

	public static void main(String[] args) {
		int[] nums = { 3, 1, 2, 4, 3, 5, 3, 5, 7, 5, 4, 5, 2, 2, 8, 5 };
		int k = 2;
		List<Integer> list = topKFrequent(nums, k);
		for (int e : list) {
			System.out.print(e + " ");
		}
	}
}
