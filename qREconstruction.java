// Time Complexity :O(n^2)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,(a,b)->{
            return a[0]==b[0]?a[1]-b[1]:b[0]-a[0];
        });
        List<int[]> out = new ArrayList<>();
        for(int[] p : people)
        {
            out.add(p[1],p);
        }
        return out.toArray(new int[people.length][2]);
    }
}