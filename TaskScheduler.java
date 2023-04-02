import java.util.Arrays;
//Time Complexity : O(NlogN)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**
 * Maintain a counts array to find the frequencies of the tasks. Then sort them.
 * The max idle time possible will be counts' last element - 1 * n. Iterate from
 * last but 1 element of counts and subtract the min(max frequency of top
 * element -1, current frequency). After that if idle time is < 0, make it 0 and
 * then return idle time + total length of task array.
 *
 */
class Solution {
	public int leastInterval(char[] tasks, int n) {
		int[] counts = new int[26];
		for (char c : tasks)
			counts[c - 'A']++;
		Arrays.sort(counts);
		int top = counts[25];
		int idle = (top - 1) * n;
		for (int i = counts.length - 2; i >= 0; i--) {
			idle -= Math.min(top - 1, counts[i]);
		}
		idle = Math.max(0, idle);
		return idle + tasks.length;
	}
}