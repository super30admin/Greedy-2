import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * The complexity of the algorithm is O(n^2) where n is no of elements.
 * Space complexity is O(n) 
 */

public class QueueReconstructionbyHeight {

	public int[][] reconstructQueue(int[][] people) {

		Arrays.sort(people, (a, b) -> {

			if (a[0] == b[0]) {

				return a[1] - b[1];
			}

			return b[0] - a[0];
		});

		List<int[]> result = new ArrayList<>();

		for (int[] person : people) {

			result.add(person[1], person);
		}

		return result.toArray(new int[0][]);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
