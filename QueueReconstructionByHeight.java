import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Time Complexity : Add : O(N^2)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class QueueReconstructionByHeight {
    public static void main(String[] args) {
        int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        reconstructQueue(people);
    }

    public static int[][] reconstructQueue(int[][] people) {

        Arrays.sort(people, (a, b) -> {  // nlog n
            if(a[0] == b[0]){ // if same height, then sort by number of person in front in ascending
                return a[1]-b[1];
            }

            return b[0]-a[0];  // Sort height according to descending order first
        });

        List<int[]> q = new ArrayList<>();  // S.C - O(N)

        for(int[] person: people){  // T.C - O(n^2)
            q.add(person[1], person);  // Iterate and add in queue based on number of person in front
        }

        return q.toArray(new int[people.length][2]);
    }
}

