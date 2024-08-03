// Time Complexity : O(nlogn)+O(n^2)
// Space Complexity :  O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, had to learn

/*
 * Problem# : 406
 * Invert always invert..
 * 
 * If we have people standed by their height in descending order, its easy to shift the highest person, by letting the person stand at the index position 
 * [7,0], [7,1], [6,1], [5,0], [5,2], [4,4]
 * if [6,1] comes at index-1 it won't alter [7,0] & [7,1]
 * [7,0], [6,1], [7,1]
 * [5,0] at index -0
 * [5,0] [7,0], [6,1], [7,1]
 * [5,2] at index-2
 * [5,0] [7,0] [5,2] [6,1], [7,1]
 * [4,4] at index-4
 * [5,0] [7,0] [5,2] [6,1] [4,4] [7,1]
 */

import java.util.*;

public class QueueReconstructionbyHeight {

    public int[][] reconstructQueue(int[][] people) {
        // sort the array by height descending
        // how to custom sort?
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });

        List<int[]> result = new ArrayList<>();

        for (int[] p : people) {
            result.add(p[1], p);
        }
        // how to convert List to Array?
        return result.toArray(new int[result.size()][]);
    }
}
