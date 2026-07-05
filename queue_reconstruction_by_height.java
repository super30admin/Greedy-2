// Time Complexity : O(n²) because inserting into an ArrayList at a specific index takes O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// We first sort people by decreasing height so taller people are placed before shorter ones.
// For people with the same height, we sort by increasing k value.
// Inserting each person at index k guarantees exactly k taller or equal-height people appear before them.

class Solution {
    public int[][] reconstructQueue(int[][] people) {

        // sort by height descending, k ascending
        Arrays.sort(people, (a, b) -> {
            if(a[0] == b[0]) {
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });

        List<int[]> res = new ArrayList<>();

        // insert each person at their k position
        for(int[] p : people) {
            res.add(p[1], p);
        }

        return res.toArray(new int[0][0]);
    }
}