package Amazon;

import java.util.ArrayList;
import java.util.List;

/*We can see that the last two digits of 4 codes at the bottom is just the descending sequence of the first 4 codes. 
 * The first 4 codes are 0, 1, 3, 2. So, we can easily get the last 4 codes: 2 + 4, 3 + 4, 1 + 4, 0 + 4,
 *  which is 6, 7, 5, 4. We can keep doing this until we reach n digits.*/
public class GrayCode {
	public List<Integer> grayCode(int n) {
		List<Integer> ret = new ArrayList<Integer>();
		ret.add(0);
		for (int i = 0; i < n; i++) {
			int size = ret.size();
			for (int j = size - 1; j >= 0; j--)
				ret.add(ret.get(j) + size);
		}
		return ret;
	}
}
