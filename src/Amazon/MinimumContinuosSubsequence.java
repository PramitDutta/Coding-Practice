package Amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumContinuosSubsequence {
	private static int[] getMinimum(List<String> target, List<String> available) {
		// Add to the map
		Map<String, List<Integer>> listMap = new HashMap<>();
		int counter = 0;
		for (String availableItem : available) {
			if (listMap.containsKey(availableItem))
				listMap.get(availableItem).add(counter);
			else {
				List<Integer> temp = new ArrayList<>();
				temp.add(counter);
				listMap.put(availableItem, temp);
			}
			counter++;
		}

		List<Integer> resultList = new ArrayList<>();
		int k = 0;
		// add all element list to resultList
		for (String targetItem : target) {
			if (listMap.get(targetItem) == null)
				break;
			else {
				int count = 0;
				int listLength = resultList.size();
				List<Integer> l = listMap.get(targetItem);
				while (count < l.size()) {
					// if you see an element getting inserted which is less that
					// the
					// last element remove one element from the front
					if (listLength > 0 && l.get(count) < resultList.get(listLength - 1))
						resultList.remove(k++);
					// add otherwise
					resultList.add(l.get(count));
					count++;
				}
			}
		}

		int left = resultList.get(0);
		int right = resultList.get(resultList.size() - 1);
		return new int[] { left, right };

	}
}
