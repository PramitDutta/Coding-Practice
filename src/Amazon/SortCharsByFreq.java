package Amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortCharsByFreq {
	public static String frequencySort(String s) {
		@SuppressWarnings("unchecked")
		List<Character>[] bucket = new List[s.length() + 1];
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (char c : s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		for (char key : map.keySet()) {
			int frequency = map.get(key);
			if (bucket[frequency] == null) {
				bucket[frequency] = new ArrayList<>();
			}
			bucket[frequency].add(key);
		}
		StringBuilder sb = new StringBuilder();
		for (int pos = bucket.length - 1; pos >= 0; pos--) {
			if (bucket[pos] != null) {
				for (char c : bucket[pos]) {
					for (int i = 0; i < map.get(c); i++) {
						sb.append(c);
					}
				}
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String str = "tree";
		String out = frequencySort(str);
		System.out.println(out);
	}

}
