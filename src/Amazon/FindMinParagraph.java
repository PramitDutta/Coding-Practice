package Amazon;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindMinParagraph {
	public int findMinParagraph(String doc, Set<String> reqWords) {
		int ii = 0, jj = 0;
		int wcount = 0;
		String curW = null;
		int minLen = Integer.MAX_VALUE;
		char[] docChars = doc.toCharArray();
		Set<String> reqSet = new HashSet<String>(reqWords);
		Map<String, Integer> countMap = new HashMap<String, Integer>();

		for (String ww : reqWords) {
			countMap.put(ww, 0);
		}

		for (jj = 0; jj < doc.length(); jj++) {
			if (!reqSet.isEmpty()) {
				curW = getWord(docChars, jj);
				if (curW == null) {
					continue;
				}
				// not null from here
				if (reqSet.contains(curW)) {
					reqSet.remove(curW);

				}
				if (countMap.containsKey(curW)) {
					countMap.put(curW, countMap.get(curW) + 1);
				}
				wcount++;
			}
			jj = jj + curW.length();

			if (reqSet.isEmpty()) {
				for (; ii < doc.length() && ii <= jj; ii++) {
					curW = getWord(docChars, ii);
					if (curW == null) {
						continue;
					}

					if (!countMap.containsKey(curW)) {
						wcount--;
					} else {
						int curCount = countMap.get(curW);
						countMap.put(curW, --curCount);
						if (curCount > 0) {
							wcount--;
						} else {
							// add this back for next walk
							reqSet.add(curW);
							break;
						}
					}
					ii = ii + curW.length();
				}

				// found the lower bound
				minLen = Math.min(minLen, wcount);

				// move up ii for next walk
				ii = ii + curW.length();
				wcount--;
			}
		}
		return minLen;
	}

	public String getWord(char[] docChars, int startIdx) {
		StringBuffer buf = new StringBuffer();
		while (startIdx < docChars.length) {
			if ((docChars[startIdx] >= 'a' && docChars[startIdx] <= 'z')
					|| (docChars[startIdx] >= 'A' && docChars[startIdx] <= 'Z')) {
				buf.append(docChars[startIdx]);
			} else {
				break;
			}
			startIdx++;
		}

		return (buf.length() == 0) ? null : buf.toString();
	}
}
