import java.util.ArrayList;
import java.util.List;
//Time Complexity : O(N)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**
 * Maintain an array to track the last index of each character in the string.
 * Also, maintain a next index variable which helps in splitting the string. Now
 * iterate over the characters of the string. At each character, check the last
 * index of it and put it in the max index possible. Repeat this for each
 * character. When the i reaches this specific max index, calculate the
 * difference between i and the next variable and add it to the answer list.
 * Update next to i+1. Finally, return the answer list.
 *
 */
class Solution {
	public List<Integer> partitionLabels(String s) {
		int[] last = new int[26];
		for (int i = 0; i < s.length(); i++)
			last[s.charAt(i) - 'a'] = i;
		List<Integer> ans = new ArrayList<>();
		int j = 0, next = 0;
		for (int i = 0; i < s.length(); i++) {
			j = Math.max(j, last[s.charAt(i) - 'a']);
			if (i == j) {
				ans.add(i - next + 1);
				next = i + 1;
			}
		}
		return ans;
	}
}
