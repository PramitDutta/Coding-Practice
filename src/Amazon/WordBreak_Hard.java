package Amazon;

import java.util.HashSet;
import java.util.Set;

public class WordBreak_Hard {
	public static int wordBreakDP(Set<String> dict, String str) {
		Set<String> memo = new HashSet<String>();
		return wordBreakUtil(dict, str, "", memo);
	}

	public static int wordBreakUtil(Set<String> dict, String str, String ouput, Set<String> memo) {
		int count = 0;
		if (memo.contains(str))
			return count + 1;
		if (str.length() == 0) {
			System.out.println(ouput);
			return count + 1;
		}

		for (int i = 1; i <= str.length(); i++) {
			String prefix = str.substring(0, i);
			if (dict.contains(prefix)) {
				memo.add(ouput + " " + prefix);
				count += wordBreakUtil(dict, str.substring(i), ouput + " " + prefix, memo);
			}
		}
		return count;
	}
}
