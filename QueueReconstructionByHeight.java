/**
 * Approach: Sort people by height in descending order; if heights are equal, sort by k value ascending.
 * Solution: Insert each person into a list at the index equal to their k value, maintaining relative order.
 * This ensures each person has exactly k taller or equal people in front when reconstruction is complete.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueueReconstructionByHeight {
    class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a,b) ->  {

            if(a[0] == b [0]) {
                return a[1] - b[1];
            }

            return b[0] - a[0];
        });

        List<int[]> result = new ArrayList<>(); 

        for(int[] p : people) {
            result.add(p[1],p);
        }

        return result.toArray(new int[0][0]);
    }
}
}
