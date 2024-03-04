/*
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(nlogn + n)
* 
* Space Complexity: O(n)
* 
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueueReconstruction {
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

        int[][] queue = new int[people.length][2];

        for (int index = 0; index < people.length; index++) {
            queue[index] = result.get(index);
        }

        return queue;
    }
}
