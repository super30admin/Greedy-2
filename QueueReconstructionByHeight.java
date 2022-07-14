// Time Complexity : O(N^2), iteration is O(N) and then adding to the list at an index is O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class QueueReconstructionByHeight {
    class Solution {
        public int[][] reconstructQueue(int[][] people) {
            Arrays.sort(people, (a, b) -> {
                if(a[0] == b[0]) return a[1] - b[1];
                return b[0] - a[0];
            });

            List<int[]> list = new ArrayList<>();
            for(int[] person : people) {
                list.add(person[1], person);
            }

            return list.toArray(people);
        }
    }
}
