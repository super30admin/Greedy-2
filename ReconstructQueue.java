// Time Complexity : O(N * N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA


// Your code here along with comments explaining your approach

// Sort the array in descending order. If height is same, sort in ascending order of k value
// Place the height in kth position of the result array
// Return the result

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        
        if(people == null || people.length == 0) return new int[][] {};
        
        Arrays.sort(people, (a, b) -> {
           if(a[0] == b[0]) {
               return a[1] - b[1];
           } return b[0] - a[0];
        });
        
        List<int[]> res = new ArrayList<>();
        
        for(int[] person : people) {
            res.add(person[1], person);
        }
        
        return res.toArray(new int[0][]);
    }
}