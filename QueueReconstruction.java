// TC: O(n^2)
// SC: O(n)

// Approach: People with bigger heights would not be affected when
// smaller heights are moved around. So, get them to the proper position first
// and then move smaller heights around

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

        List<int[]> res = new ArrayList<>();

        for (int i = 0; i < people.length; i++) {
            res.add(people[i][1], people[i]);
        }

        return res.toArray(new int[res.size()][2]);
    }
}
