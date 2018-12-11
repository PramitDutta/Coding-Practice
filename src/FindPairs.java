import java.util.HashMap;
import java.util.Map;

public class FindPairs {
	public static int[] pairSum(int[] arr) {
		int[] result = new int[2];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (!map.containsKey(arr[i])) {
				map.put(arr[i], i);
			}
			if (map.containsKey(10 - arr[i])) {
				result[1] = i;
				result[0] = map.get(10 - arr[i]);
				break;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 6, 8, 4, 7 };
		int[] result = pairSum(arr);
		for (int i : result)
			System.out.print(i + " ");
	}
}
