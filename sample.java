// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

import java.util.*;
class Sample {
    // Time Complexity : O(N) where N is length of string
    // Space Complexity : O(1)
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No


    // Approach:
    /*
    1. Find the last index of the first character occurring in the string.
    **/
    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();
        if(S == null || S.length() == 0)
            return result;
        
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i< S.length(); i++) {
            map.put(S.charAt(i), i);
        }
        
        int start = 0, end = 0;
        for(int i=0; i<S.length(); i++) {
            end = Math.max(end, map.get(S.charAt(i)));
            if(i == end) {
                result.add(end - start + 1);
                start = end + 1;
            }
        }
        
        return result;
    }

    // Time Complexity : O(N) where N is length of array
    // Space Complexity : O(N)
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No


    /**
     * 1. Sort the array based on decreasing height and then arrange them as per their position.
     */

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        
        List<int[]> result = new ArrayList<>();
        
        for(int[] p : people){
            result.add(p[1], p);
        }
        
        return result.toArray(new int[0][]);
    }
}
