//Time Complexity: O(nlogn + n^2), O(n^2) asymptotic
//Space Complexity: O(n)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReconstructQueue {
    public int[][] reconstructQueue(int[][] people) {
        if(people == null || people.length == 0) return new int[0][0];
        Arrays.sort(people, (a,b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        List<int[]> result = new ArrayList<>();
        for(int[] person: people){
            result.add(person[1], person);
        }
        return result.toArray(new int[0][]);
    }
}
