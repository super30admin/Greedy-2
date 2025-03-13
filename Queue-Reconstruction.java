## Problem2 Queue Reconstruction by Height (https://leetcode.com/problems/queue-reconstruction-by-height/)

TC : O(n^2)
SC : O(n)

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if(people==null || people.length==0){
            return new int[][]{};
        }
        Arrays.sort(people,(a,b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return b[0] - a [0];
        });
        List<int[]> q = new ArrayList<>();
        for(int[] person : people){
            q.add(person[1], person);
        }
        return q.toArray(new int[][]{});
    }
}