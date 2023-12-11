// Time Complexity : O(nlogn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class QueueReconstructHeight {
    class Solution {
        public int[][] reconstructQueue(int[][] people) {
            Arrays.sort(people, (a, b) -> {
                if(a[0] == b[0]){
                    return a[1] - b[1];
                }
                return b[0] - a[0];
            });

            List<int[]> list = new ArrayList<>();
            for(int[] person : people){
                list.add(person[1], person);
            }

            int[][] result = new int[people.length][2];
            for(int i = 0; i < list.size(); i++){
                result[i] = list.get(i);
            }
            return result;
        }
    }
}
