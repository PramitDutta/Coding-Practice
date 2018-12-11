package Amazon;

public class MinColoring {
	static int min_coloring(int num, String s) {
		int count = 0;
		char arr[] = s.toCharArray();
		int i = 1;
		int currentInterval = 1;
		boolean isSubStringSizeMoreThanK = false;
		while (i < arr.length) {
			if (arr[i] == arr[i - 1]) {
				currentInterval++;
			}
			if (arr[i] != arr[i - 1] || i == arr.length - 1) {
				if (currentInterval < num) {
					count++;
				} else {
					isSubStringSizeMoreThanK = true;
					count += (int) Math.ceil((double) currentInterval / num);
				}
				currentInterval = 1;
			}
			i++;
		}
		if (isSubStringSizeMoreThanK) {
			return count;
		} else {
			return -1;
		}
	}

	public static void main(String args[]) {
		System.out.println(min_coloring(3, "rrggg"));
	}
}
