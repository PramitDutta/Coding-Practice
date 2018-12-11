package Amazon;

import java.util.ArrayList;
import java.util.HashMap;

public class InsertDeleteGetRandom_O1 {
	ArrayList<Integer> nums;
	HashMap<Integer, Integer> locs;
	java.util.Random rand = new java.util.Random();

	public InsertDeleteGetRandom_O1() {
		nums = new ArrayList<Integer>();
		locs = new HashMap<Integer, Integer>();
	}

	public boolean insert(int val) {
		boolean contains = locs.containsKey(val);
		if (contains)
			return false;
		locs.put(val, nums.size());
		nums.add(val);
		return true;
	}

	public boolean remove(int val) {
		boolean contains = locs.containsKey(val);
		if (!contains)
			return false;
		int loc = locs.get(val);
		if (loc < nums.size() - 1) { // not the last one, then swap the last one
										// with this val
			int lastOne = nums.get(nums.size() - 1);
			nums.set(loc, lastOne);
			locs.put(lastOne, loc);
		}
		locs.remove(val);
		nums.remove(nums.size() - 1);
		return true;
	}

	public int getRandom() {
		return nums.get(rand.nextInt(nums.size()));
	}
}
