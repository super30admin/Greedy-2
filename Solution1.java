// Time complexity - O(n^2)
// Space - O(1) - since o/p doesn't count
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Problem1 Queue Reconstruction by Height (https://leetcode.com/problems/queue-reconstruction-by-height/)

class Solution1 {
    public int[][] reconstructQueue(int[][] people) {
        // Sort in descending order of height and then asc k
        Arrays.sort(people, (a,b) -> a[0] != b[0] ? b[0] - a[0] : a[1] - b[1]);
        
        
        List<int[]> list = new LinkedList<>();
        for(int[] p : people){
            list.add(p[1], p);
        }
        return list.toArray(new int[list.size()][2]);
    }
}