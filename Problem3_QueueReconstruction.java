// Time Complexity : o(nlogn)
// Space Complexity : o(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        
        if (people == null || people.length == 0) {
			return new int[0][];
		}

		Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);

		List<int[]> queue = new ArrayList<>();

		for (int[] person : people) {
			queue.add(person[1], person);
		}

		return queue.toArray(new int[0][]);
    }
}