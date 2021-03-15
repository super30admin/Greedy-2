import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
// Time Complexity :O(n^2)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : getting started

// Your code here along with comments explaining your approach
public class QueueReconstructionByHeight {
    class Solution {
        public int[][] reconstructQueue(int[][] people) {
            //sort array based on decreasing order of height, if height is same then sort by ascending order of k
            Arrays.sort(people, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
                }
            });

            //iterate through people, for each people[i], try to directly put it in the correct position.
            List<int[]> output = new LinkedList<>();
            for(int[] p : people){
                output.add(p[1], p);
            }

            int n = people.length;
            return output.toArray(new int[n][2]);//conver to arraylist
        }
    }
}
