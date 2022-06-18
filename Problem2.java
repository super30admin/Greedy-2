import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2 {
    // TC : O(n^2)
    // SC : O(n)
    public int[][] reconstructQueue(int[][] people) {
        if (people == null) return new int[][]{};


        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });

        List<int[]> result = new ArrayList<>();

        for (int[] person : people) {
            result.add(person[1], person);
        }
        return result.toArray(new int[result.size()][]);
        //return result.toArray(people);
    }
}
