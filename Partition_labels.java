
// TC - O(N)
// SC - O(1) //Since we are using hashmap of characters, space would be  constant
import java.util.*;

class Solution {
	public List<Integer> partitionLabels(String S) {
		// edge case
		List<Integer> result = new ArrayList<>();
		if (S == null || S.length() == 0)
			return result;
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);
			map.put(c, i);
		}
		int start = 0;
		int end = 0;
		for (int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);
			end = Math.max(end, map.get(c));
			if (i == end) {
				result.add(end - start + 1);
				start = end + 1;
			}
		}
		return result;
	}
}