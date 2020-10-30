    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/queue-reconstruction-by-height/
    Time Complexity for operators : o(n) .. n is the length people
    Extra Space Complexity for operators : o(n) .. size of list
    Did this code successfully run on Leetcode : NA
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : 
        # Optimized approach: 
                              
            # 1. 
                    A) Create array result and fill 1 in each position as each person must have one candy.
                    B) Then start from Front and check ratings[i]>ratings[i-1] if it is then add 1 to the previous and change current
                        like result[i] = result[i-1] + 1;
                    C) Now, start from end, check ratings[i]>ratings[i+1] if it is then do below 
                       result[i] = Math.max(result[i], result[i+1]+1);
                    D) At the end, sum all the values from array and return the sum.
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