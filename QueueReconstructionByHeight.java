import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueueReconstructionByHeight {
    // TC: O(N * N) where N is length of people array
    // SC: O(N) where N is length of people array
    public int[][] reconstructQueue(int[][] people) {
        int n = people.length;
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            } else {
                return b[0] - a[0];
            }
        });
        List<int[]> resList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int[] curr = people[i];
            resList.add(curr[1], curr);
        }
        return resList.toArray(new int[n][2]);
    }
}
