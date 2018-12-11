package Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindKElementSum {
	public static List<List<Integer>> findKElementsSum(int k, int n) {
		List<List<Integer>> list = new ArrayList<>();
		for (int i = 1; i < n - 2; i++) {
			for (int j = i + 1; j < n - 1; j++) {
				int r = n - (i + j);
				if (r != i && r != j && r <= n && r > 0) {
					list.add(Arrays.asList(i, j, r));
				}
			}
		}
		return list;
	}

	public static void main(String[] args) {
		List<List<Integer>> result = findKElementsSum(3, 9);
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
	}
}
