// Time Complexity : O(N)
// Space Complexity : O(1) //only lower case letters
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/*
 * 1. find end index of each character and store in a map.
 * 2. travel from first character and find last index from map and when index==end add it to result.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {
	public List<Integer> partitionLabels(String s) {

		Map<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			map.put(s.charAt(i), i);
		}

		List<Integer> result = new ArrayList<>();
		int start = 0;
		int end = 0;
		for (int i = 0; i < s.length(); i++) {
			end = Math.max(end, map.get(s.charAt(i)));
			if (end == i) {
				result.add(end - start + 1);
				start = end + 1;
			}
		}
		return result;
	}
}
