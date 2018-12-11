package LeetCode_Medium;

import java.util.ArrayList;
import java.util.List;

public class Zigzag_Conversion {
	public static String convert(String s, int numRows) {
		if (s == null || s.length() < 2 || numRows < 2)
			return s;

		List<StringBuilder> list = new ArrayList<StringBuilder>();
		for (int i = 0; i < numRows; i++) {
			list.add(new StringBuilder());
		}

		boolean isGoingDown = true;
		int index = 0;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			list.get(index).append(c);

			if (isGoingDown) {
				if (index == numRows - 1) {
					index = numRows - 2;
					isGoingDown = false;
				} else {
					index++;
				}

			} else {
				if (index == 0) {
					index = 1;
					isGoingDown = true;
				} else {
					index--;
				}

			}
		}
		StringBuilder res = new StringBuilder();
		for (StringBuilder sb : list) {
			res.append(sb.toString());
		}
		return res.toString();
	}

	public static void main(String[] args) {
		String str = "PAYPALISHIRING";
		String out = convert(str, 3);
		System.out.println(out);
	}
}
