// Time Complexity : O(nlogn)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

/*
Appraoch
we will use the sort fuction in decending way using custom comparator, we will height to compare but
if height is same we use "people ahead" num for comparation
*/

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });
        for (int[] person : people) {
            result.add(person[1], person);
        }
        return result.toArray(new int[0][]);
    }
}