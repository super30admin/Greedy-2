import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueueReconstruction {
    // First arrange the people in the decreasing order of their heights
    // and then put a person at an index specified by 1st index
    // TC : O(n^2)
    // SC : O(n)
    public int[][] reconstructQueue(int[][] people) {
        if(people == null || people.length == 0) return new int[][]{};

        Arrays.sort(people, (a,b) -> { // TC : O(n * log n)
            if(a[0] == b[0]) return a[1] - b[1]; // if they have same height, increasing order of the 1st index
            return b[0] - a[0]; // else decreasing order of the height
        });

        List<int[]> result = new ArrayList<>();
        for(int[] person : people) { // TC : O(n^2)
            result.add(person[1], person);
        }

        return result.toArray(new int[0][]); // it can be new int[people.length][] as well but not any random value
                                            // if it would've been new int[10][], resultant array will have null elements once the collection is over
    }
}
