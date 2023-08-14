// Time Complexity : O(n log n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach:
// The reconstructQueue function first sorts the people array in descending order based on heights and then in ascending order based on the number of people in front. It reconstructs the queue by inserting each person at the specified position in a list using their count of people in front. The resulting list is converted back to an array, representing the reconstructed queue.
// Sort people array by height and count of people in front. Insert each person into a list at the designated position using count of people in front. Convert the list back to an array to represent the reconstructed queue.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        // Sort the people array in descending order based on their heights. If heights
        // are equal, sort based on the number of people in front.
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });

        List<int[]> li = new ArrayList<>();
        for (int[] person : people) {
            li.add(person[1], person);
        }

        int[][] result = new int[people.length][2];

        for (int i = 0; i < li.size(); i++) {
            result[i] = li.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        QueueReconstructionByHeight queueReconstruction = new QueueReconstructionByHeight();

        int[][] people1 = { { 7, 0 }, { 4, 4 }, { 7, 1 }, { 5, 0 }, { 6, 1 }, { 5, 2 } };
        int[][] result1 = queueReconstruction.reconstructQueue(people1);
        System.out.println("Reconstructed Queue (people1):");
        for (int[] person : result1) {
            System.out.println(Arrays.toString(person));
        }

        int[][] people2 = { { 6, 0 }, { 5, 0 }, { 4, 0 }, { 3, 2 }, { 2, 2 }, { 1, 4 } };
        int[][] result2 = queueReconstruction.reconstructQueue(people2);
        System.out.println("Reconstructed Queue (people2):");
        for (int[] person : result2) {
            System.out.println(Arrays.toString(person));
        }
    }
}
