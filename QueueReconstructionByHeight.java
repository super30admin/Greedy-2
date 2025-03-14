//TC: O(n^2)
//SC: O(n)
//approach: greedy - reverse by height, and then start placing from start based on second index

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        List<int []> result = new ArrayList<>();
        for(int [] p : people){
            result.add(p[1], p);
        }
        return result.toArray(new int [0][]);
    }
}
