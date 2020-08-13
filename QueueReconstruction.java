// Time Complexity : O(n^2) --> where n is the length of input people array
// Space Complexity : O(n)
// Did this code successfully run on Leetcode (406): Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int[][] reconstructQueue(int[][] people) {
         Arrays.sort(people, (a,b) -> {
             if (a[0] == b[0]) return a[1] - b[1];
             else return b[0] - a[0];
         });
        
        List<int[]> output = new ArrayList<>();
        for(int[] p : people){
            output.add(p[1], p);
        }

        int n = people.length;
        return output.toArray(new int[n][2]);
    }
}