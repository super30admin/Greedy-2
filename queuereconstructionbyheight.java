// TC: O(n ^ 2)
// SC: O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> 
            a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]
        );
        
        List<int[]> result = new ArrayList<>();
        for (int[] p : people) {
            result.add(p[1], p);
        }
        
        return result.toArray(new int[0][]);
    }
}
