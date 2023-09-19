// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/*
 * Record the last seen index for each character in a map.
 * Iterate though the string and check if curr index is the ending for that partition.
 * Count the partiton, once index crosses the end index.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        int n = s.length();

        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            map.put(ch, i);
        }

        int start = 0, end = 0;
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            end = Math.max(end, map.get(ch));
            if(i == end){
                result.add(end - start + 1);
                start = i + 1;
            }
        }

        return result;
    }
}