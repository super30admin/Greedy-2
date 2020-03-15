//Time complexity is O(2n) -> O(n)
//Space complexity is O(1) as only 26 Alphabet characters are there
//This solution is submitted on leetcode

import java.util.ArrayList;
import java.util.List;

public class BigN139PartitionLabelsSolution {
	class Solution {
		public List<Integer> partitionLabels(String S) {
			List<Integer> result = new ArrayList<>();
			// edge case
			if (S == null || S.length() == 0)
				return result;
			int[] map = new int[26];
			for (int i = 0; i < S.length(); i++) {
				char c = S.charAt(i);
				map[c - 'a'] = i;
			}
			int start = 0;
			int end = 0;
			for (int i = 0; i < S.length(); i++) {
				char c = S.charAt(i);
				end = Math.max(end, map[c - 'a']);
				if (end == i) {
					result.add(end - start + 1);
					start = end + 1;
				}
			}
			return result;
		}
	}
}