// Time Complexity : O(N pow 2) // and nlogn for sort
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


/*
 * 1. sort array by height. if height is same by in front people count.
 * 2. add each element at right place by the front people count.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueueReconstructionbyHeight {
	public int[][] reconstructQueue(int[][] people) {

		Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
		List<int[]> result = new ArrayList<>();

		for (int i = 0; i < people.length; i++) {
			result.add(people[i][1], people[i]);
		}

		return result.toArray(new int[0][]);
	}
}
