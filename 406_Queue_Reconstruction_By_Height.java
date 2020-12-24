    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/queue-reconstruction-by-height/
    Time Complexity for operators : o(n^2) .. n is the length people AND extra n will take to create array and perticular index.
    Extra Space Complexity for operators : o(n) .. size of list
    Did this code successfully run on Leetcode : NA
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : 
        # Optimized approach: 
                              
            # 1. 
                    A) Sort the Array if heighs are equal then sort by frequence else by heights.
                    B) Create list and add elements like below. list.add(p[1],p);
                    C) Then, return that list as a array.
    */ 

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a,b) -> (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]));
        
        List<int[]> list = new ArrayList<>();
        
        for(int[] p : people){
            list.add(p[1],p);
        }
        
        return list.toArray(new int[0][]);
    }
}