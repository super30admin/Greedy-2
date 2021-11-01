package Greedy2;

//Time complexity : O(n^2)
//Space complexity: O(n)
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if(a[0] == b[0])
                return a[1] - b[1];
            return b[0] - a[0];
        });
        List<int[]> q = new ArrayList<>();
        for(int i=0; i<people.length; i++){
            q.add(people[i][1], people[i]);
        }
        return q.toArray(new int[0][]);
    }
}
