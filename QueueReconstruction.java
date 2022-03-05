import java.util.*;

// Time Complexity : O(n^2), where n is the length of people array
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
class QueueReconstruction {
    public int[][] reconstructQueue(int[][] people) {
        // null
        if (people == null || people.length == 0)
            return new int[0][0];
        // sort in descending order
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) { // if heights are equal return ascending order of number of people ahead
                return a[1] - b[1];
            }
            return b[0] - a[0]; // else return descending order of heights
        });
        // pick and place in the list as per index
        List<int[]> list = new ArrayList();
        for (int[] person : people) {
            list.add(person[1], person);
        }
        return list.toArray(new int[people.length][2]);
    }
}