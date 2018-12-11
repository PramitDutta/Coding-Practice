package Amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class InsertDeleteGetRandom_Duplicates {
	ArrayList<Integer> nums;
	HashMap<Integer, Set<Integer>> locs;
	java.util.Random rand = new java.util.Random();

	public InsertDeleteGetRandom_Duplicates() {
		nums = new ArrayList<Integer>();
		locs = new HashMap<Integer, Set<Integer>>();
	}

	public boolean insert(int val) {
		boolean contains = locs.containsKey(val);
		if (contains)
			return false;
		locs.put(val, new HashSet<Integer>());
		locs.get(val).add(nums.size());
		nums.add(val);
		return true;
	}

	public boolean remove(int val) {
		boolean contains = locs.containsKey(val);
		if (!contains)
			return false;
		int loc = locs.get(val).iterator().next();
		locs.get(val).remove(loc);
		if (loc < nums.size() - 1) { // not the last one, then swap the last one
										// with this val
			int lastOne = nums.get(nums.size() - 1);
			nums.set(loc, lastOne);
			locs.get(lastOne).remove(nums.size() - 1);
			locs.get(lastOne).add(loc);
		}
		if (locs.get(val).isEmpty())
			locs.remove(val);
		nums.remove(nums.size() - 1);
		return true;
	}

	public int getRandom() {
		return nums.get(rand.nextInt(nums.size()));
	}
}
