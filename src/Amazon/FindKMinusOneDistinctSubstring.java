package Amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindKMinusOneDistinctSubstring {
	public static List<String> findKMinusOneDistinct(String s, int k) {
		Map<Character, Integer> occurrenceMap = new HashMap<>();
		List<String> resultList = new ArrayList<>();

		for (int i = 0; i + k <= s.length(); i++) {

			String str = s.substring(i, i + k);

			boolean isRepeat = false;

			for (char c : str.toCharArray()) {
				if (occurrenceMap.containsKey(c)) {
					if (!isRepeat)
						occurrenceMap.put(c, occurrenceMap.get(c) + 1);
					else
						break;

					isRepeat = true;
				} else
					occurrenceMap.put(c, 1);
			}
			// if it makes it through and has precisely 1 repeat character
			if (isRepeat)
				resultList.add(str);
			// empty the map
			occurrenceMap.clear();
		}

		return resultList;
	}

	public static void main(String[] args) {
		String input = "abdbcdefgh";
		List<String> result = findKMinusOneDistinct(input, 4);
		for (String s : result) {
			System.out.println(s);
		}
	}
}
