import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Time Complexity : O(n*n) where n = length of people array
// Space Complexity : O(n) where n = length of people array
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//406. Queue Reconstruction by Height (Medium) - https://leetcode.com/problems/queue-reconstruction-by-height/
// Time Complexity : O(n*n) where n = length of people array
// Space Complexity : O(n) where n = length of people array
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0) return new int[0][];
        
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) {
               return a[1] - b[1];
            }
            return b[0] - a[0];
        });
        
        List<int []> result = new ArrayList<>(); // O(n)
        
        for (int [] person : people) {
            result.add(person[1], person);
        }
        
        return result.toArray(new int[0][]);
    }
}