//Time complexity : O(n^2)
//Space Complexity : O(n)
//Did it run on leetcode : yes

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueueReconstruction {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b)->{
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });
        List<int[]> q = new ArrayList<>();
        for(int[] person : people){
            q.add(person[1], person);
        }
        return q.toArray(new int[people.length][2]);
    }

}
