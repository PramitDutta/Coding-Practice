
package Amazon;

import java.util.HashMap;
import java.util.Map;

/*So if we know SUM[0, i - 1] and SUM[0, j], then we can easily get SUM[i, j]
 
 */
public class SubArraySumEqualsK {
	public int subArraySum(int[] nums, int k) {
		int sum = 0, result = 0;
		Map<Integer, Integer> preSum = new HashMap<>();
		preSum.put(0, 1);

		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (preSum.containsKey(sum - k)) {
				result += preSum.get(sum - k);
			}
			preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
		}

		return result;
	}
}
