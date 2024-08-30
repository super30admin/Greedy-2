// Time Complexity: O(n^2)
// Space Complexity: O(n)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0])
                return a[1] - b[1];
            return b[0] - a[0];
        });

        List<int[]> result = new ArrayList<>();
        for (int[] person : people) {
            result.add(person[1], person);
        }

        int[][] resultInt = new int[people.length][2];
        for (int i = 0; i < result.size(); i++) {
            resultInt[i] = result.get(i);
        }

        return resultInt;
    }
}