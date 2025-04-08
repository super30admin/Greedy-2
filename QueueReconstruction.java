/*
 * TC: O(n log n) (Sorting)
 * SC: O(n) (Creating a temp list for result)
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueueReconstruction {
    public int[][] reconstructQueue(int[][] people) {
        // sort in descending order of heights
        // but for same heights, put the person
        // with fewer people ahead of them first
        Arrays.sort(people, (a, b) -> {
            if(a[0] != b[0]) {
                return b[0] - a[0];
            } else {
                return a[1] - b[1];
            }
        });
        // now just insert into the result at the index
        // given by number of people in front of person
        List<int[]> resList = new ArrayList<>();
        for(int[] person: people) {
            resList.add(person[1], person);
        }
        return resList.toArray(new int[people.length][]);
    }
}
