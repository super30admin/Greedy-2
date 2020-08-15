
// TC - O(N^2)
// SC - O(N)
import java.util.*;

class Solution1 {
	public int[][] reconstructQueue(int[][] people) {
		Arrays.sort(people, (a, b) -> {
			if (a[0] == b[0])
				return a[1] - b[1];
			return b[0] - a[0];
		});
		List<int[]> result = new ArrayList<>();
		for (int[] person : people) {
			result.add(person[1], person);
		}
		return result.toArray(new int[0][]);
	}
}