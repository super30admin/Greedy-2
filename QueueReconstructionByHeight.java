// Time Complexity : O(nlogn) + O(n^2) => O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
We first sort the input array based on the descending order of heights and if they are equal, sort in
ascending order of the number of people in front of them. Now, we take a list and add each person at that
index which is equal to the how many number of people infront of them. This way, taller people are already
placed at the start, others can be arranged depending upon their expectation.
 */
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if(a[0] == b[0]) {
                return a[1] - b[1];
            }
            else
                return b[0] - a[0];
        });

        List<int[]> result = new ArrayList<>();

        for(int[] p : people) {
            result.add(p[1] , p);
        }

        return result.toArray(new int[0][0]);
    }
}