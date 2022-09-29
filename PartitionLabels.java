import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Time Complexity : O(n) where n = length of string
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//763. Partition Labels (Medium) - https://leetcode.com/problems/partition-labels/
// Time Complexity : O(n) where n = length of string
// Space Complexity : O(1)
class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        
        if (s == null || s.length() == 0) return result;
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) { // O(n)
            char ch = s.charAt(i);
            map.put(ch, s.lastIndexOf(ch));
        }
        
        int start = 0, end = map.get(s.charAt(0));
        
        for (int j = 0; j < s.length(); j++) { // O(n)
            char ch = s.charAt(j);
            int lastIndex = map.get(ch);
            end = Math.max(end, lastIndex);
            
            if (end == j) {
                result.add(end-start+1);
                start = j+1;
            }
        }
        
        return result;
    }
}