// Problem 406. Queue Reconstruction by Height
// Time Complexity : O(n*n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // Sort by height in descending order. If heights are the same, sort by k-value in ascending order.
        Arrays.sort(people, (a, b) -> {
            if (a[0] != b[0]) {
                return b[0] - a[0]; // Sort by height (h) descending
            } else {
                return a[1] - b[1]; // Sort by k ascending
            }
        });
        List<int[]> result = new LinkedList<>();
        for (int[] person : people) {
            result.add(person[1], person);
        }
        return result.toArray(new int[people.length][2]);
    }
}

