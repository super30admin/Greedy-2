// Time Complexity : O(n^2) // inserting in queue at the index
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a,b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });

        List<int[]> q = new LinkedList<>();
        for(int[]person : people){
            q.add(person[1], person);
        }
        return q.toArray(new int[][]{});
    }
}