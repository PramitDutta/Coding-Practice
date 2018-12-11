package Leetcode_Blocked;

import java.util.ArrayList;
import java.util.List;

public class Valid_WordSquare {
	public static boolean validWSquare(List<String> words) {
		if (words == null || words.size() == 0)
			return true;

		int n = words.size();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < words.get(i).length(); j++) {
				if (j >= n || words.get(j).length() <= i || words.get(j).charAt(i) != words.get(i).charAt(j))
					return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		List<String> words = new ArrayList<String>();
		words.add("ball");
		words.add("area");
		words.add("lead");
		words.add("lady");
		System.out.println(validWSquare(words));
	}
}
