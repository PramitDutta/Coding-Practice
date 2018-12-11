package Amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class PartitionLabels {
	public static List<Integer> partitionLabels(String S) {
		int[] last = new int[26];
		for (int i = 0; i < S.length(); i++) {
			last[S.charAt(i) - 'a'] = i;
		}

		int j = 0, anchor = 0;
		List<Integer> ans = new ArrayList<Integer>();
		for (int i = 0; i < S.length(); i++) {
			j = Math.max(j, last[S.charAt(i) - 'a']);
			if (i == j) {
				ans.add(i - anchor + 1);
				anchor = i + 1;
			}
		}
		return ans;
	}

	public static int[] findMinimalOverlapSubsequence(String str) {
		// to find the index of each character
		Map<Character, Integer> map = new HashMap<>();
		// to track repeated character sequence
		int[] arr = new int[str.length()];
		arr[0] = -1;
		map.put(str.charAt(0), 0);

		for (int i = 1; i < arr.length; i++) {
			char ch = str.charAt(i);
			if (map.containsKey(ch)) {
				arr[i] = map.get(ch);
			} else {
				arr[i] = i - 1;
				map.put(ch, i);
			}
		}
		int end = arr.length - 1;
		Stack<Integer> breakPoints = new Stack<>();
		while (end >= 0) {
			char ch = str.charAt(end);
			int begin = map.getOrDefault(ch, end);
			// if the current char is unique
			if (begin == end) {
				breakPoints.push(1);
				end = arr[end];
			} else {
				int minIndex = findMinIndex(arr, begin + 1, end);
				while (minIndex < begin) {
					int prevBegin = begin;
					begin = minIndex;
					minIndex = findMinIndex(arr, begin + 1, prevBegin);
				}
				breakPoints.push(end - arr[minIndex]);
				end = arr[minIndex];
			}
		}
		int[] result = new int[breakPoints.size()];
		int resultIndex = 0;
		while (!breakPoints.isEmpty()) {
			result[resultIndex++] = breakPoints.pop();
		}
		return result;
	}

	private static int findMinIndex(int[] arr, int beg, int end) {
		int min = Integer.MAX_VALUE;
		while (beg <= end) {
			min = Math.min(min, arr[end]);
			end--;
		}

		return min;
	}

	public static void main(String[] args) {
		String S = "ababcbacadefegdehijhklij";
		int[] result = findMinimalOverlapSubsequence(S);
		for (int n : result) {
			System.out.print(n + " ");
		}
	}
}
