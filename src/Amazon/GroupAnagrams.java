package Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		if (strs == null || strs.length == 0)
			return new ArrayList<List<String>>();

		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for (String s : strs) {
			char[] c = s.toCharArray();
			Arrays.sort(c);
			String keyStr = String.valueOf(c);
			if (!map.containsKey(keyStr)) {
				map.put(keyStr, new ArrayList<String>());
			}
			map.get(keyStr).add(s);
		}
		return new ArrayList<List<String>>(map.values());
	}
}
