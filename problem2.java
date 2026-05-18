import java.util.*;

class Solution {

    /**
    Time Complexity : O(N^2)
    Explanation:
    - Sorting takes O(N log N)
    - Inserting into ArrayList at specific index takes O(N)
    - Total worst case becomes O(N^2)

    Space Complexity : O(N)
    Explanation:
    Extra list is used to reconstruct the queue.

    Did this code successfully run on LeetCode : Yes

    Any problem you faced while coding this :
    Initially tried placing shorter people first,
    but later insertions disturbed the arrangement.
    Fixed it by:
        1) Sorting taller people first
        2) For same height, sort by smaller k first
    Then inserting each person at index k automatically places them
    in the correct position.
    */

    public int[][] reconstructQueue(int[][] people) {

        List<int[]> li = new ArrayList<>();

        // Sort:
        // height descending
        // k ascending
        Arrays.sort(people, (a, b) -> {

            if (a[0] == b[0]) {
                return a[1] - b[1];
            }

            return b[0] - a[0];
        });

        // Insert person at index k
        for (int[] person : people) {
            li.add(person[1], person);
        }

        // Convert list to array
        int[][] res = new int[li.size()][2];

        for (int i = 0; i < li.size(); i++) {
            res[i] = li.get(i);
        }

        return res;
    }
}