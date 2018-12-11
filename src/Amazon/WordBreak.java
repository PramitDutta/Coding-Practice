package Amazon;

import java.util.ArrayList;
import java.util.List;

public class WordBreak {
	public static boolean wordBreak(String s, List<String> wordDict) {
		boolean f[] = new boolean[s.length() + 1];
		f[0] = true;
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (f[j] && wordDict.contains(s.substring(j, i))) {
					f[i] = true;
					break;
				}
			}
		}
		return f[s.length()];
	}

	public static void main(String[] args) {
		String s = "catsanddog";
		List<String> list = new ArrayList<String>();
		list.add("cat");
		list.add("cats");
		list.add("and");
		list.add("sand");
		list.add("dog");
		boolean result = wordBreak(s, list);
		System.out.println(result);

	}
}
