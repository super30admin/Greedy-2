/*
Did this code successfully run on Leetcode :  Yes
Any problem you faced while coding this :  No

Time Complexity - O(n^2) +  nlogn for sorting
Java’s ArrayList.add(index, element) takes O(n) time in the worst case because elements may need to be shifted.
So for n people, the total insertion time is: O(n^2)
Space Complexity -  O(N)
The output list result stores all n people
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueueReconstructionbyHeight_LC_406 {
    public int[][] reconstructQueue(int[][] people) {
        List<int[]> result = new ArrayList<>();
        //Step 1 : Sort by height descending, and by k ascending for same height
        Arrays.sort(people, (a, b) -> {
            if (a[0] != b[0]) return b[0] - a[0]; // taller first
            else return a[1] - b[1];              // smaller k first
        });

        // Step 2: Insert each person at index = k
        for (int[] person : people) {
            result.add(person[1], person); // insert at index k
        }

        // Convert list back to array
        return result.toArray(new int[people.length][2]);
        //return result.toArray(new int[0][]);

    }
}