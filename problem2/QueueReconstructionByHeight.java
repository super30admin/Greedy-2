// Time Complexity : O(n*n), n -> Number of heights
// Space Complexity : O(n*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueueReconstructionByHeight {
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

	private void print(int[][] people) {
		for (int i = 0; i < people.length; i++) {
			for (int j = 0; j < people[0].length; j++) {
				System.out.print(people[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		QueueReconstructionByHeight obj = new QueueReconstructionByHeight();

		int[][] people = { { 7, 0 }, { 4, 4 }, { 7, 1 }, { 5, 0 }, { 6, 1 }, { 5, 2 } };

		int[][] reconstructedQueue = obj.reconstructQueue(people);
		System.out.println("Result:");
		obj.print(reconstructedQueue);
	}

}
