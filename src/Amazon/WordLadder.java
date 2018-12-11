
package Amazon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder {
	public static class WordNode {
		String word;
		int numSteps;

		public WordNode(String word, int numSteps) {
			this.word = word;
			this.numSteps = numSteps;
		}
	}

	public static int ladderLength(String start, String end, List<String> wordList) {
		Queue<WordNode> queue = new LinkedList<WordNode>();
		queue.add(new WordNode(start, 1));

		wordList.add(end);
		while (!queue.isEmpty()) {
			WordNode top = queue.remove();
			String word = top.word;

			if (word.equals(end)) {
				return top.numSteps;
			}

			char[] arr = word.toCharArray();
			for (int i = 0; i < arr.length; i++) {
				for (char c = 'a'; c <= 'z'; c++) {
					char temp = arr[i];
					if (arr[i] != c) {
						arr[i] = c;
					}
					String newWord = new String(arr);
					if (wordList.contains(newWord)) {
						queue.add(new WordNode(newWord, top.numSteps + 1));
						wordList.remove(newWord);
					}
					arr[i] = temp;
				}
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("hot");
		list.add("dot");
		list.add("dog");
		list.add("lot");
		list.add("log");
		String start = "hit";
		String end = "cog";
		int result = ladderLength(start, end, list);
		System.out.println(result);
	}
}
