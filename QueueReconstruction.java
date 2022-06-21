/*
 * TC = O(N^2)
 * SC = O(N)
 * 
 * Approach: We sort according to the heights and persons infront and then add to the
 * final list accordingly.
 */

import java.util.*;
public class QueueReconstruction {
    public static int[][] reconstructQueue(int[][] people) {
        if(people == null || people.length == 0) return new int[][]{};
        
        Arrays.sort(people, (a,b)->{
           if(a[0] == b[0])
           {
               return a[1]-b[1];
           }
            return b[0]-a[0];
        });
        
        List<int[]> result = new ArrayList<>();
        for(int[] person: people)
        {
            result.add(person[1],person);
        }
        
        return result.toArray(new int[0][]);
    }
}
