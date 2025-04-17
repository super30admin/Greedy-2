import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Time Complexity: O(N^2)
 * Space Complexity: O(N)
 * Did this code successfully run on Leetcode: Yes
 * Any problem you faced while coding this: None

 * Approach:
 * 1. Sort people: In descending order by height.
 * 2. Among the guys of the same height, in the ascending order by k-values.
 * 3. Take guys one by one, and place them in the output array at the indexes equal to their k-values.
 */

public class QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // if the heights are equal, compare k-values
                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });

        List<int[]> result = new LinkedList<>();
        for (int[] p: people) {
            result.add(p[1], p);
        }

        int n = people.length;
        return result.toArray(new int[n][2]);
    }
    public static void main(String[] args) {
        // Your code here
    }
}