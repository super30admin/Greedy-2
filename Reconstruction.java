// Time Complexity: O(n^2) where n is the number of people
// Space Complexity: O(n) where n is the number of people

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Reconstruction {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if(a[0] == b[0]){
                return a[1]-b[1];
            }
            return b[0] - a[0];
        });

        List<int[]> res = new ArrayList<>();

        for(int[] person: people){
            res.add(person[1], person);
        }

        return res.toArray(new int[res.size()][]);
    }
}