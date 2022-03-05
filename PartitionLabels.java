import java.util.*;
// Time Complexity : O(n), where n is the length of string s
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        // null
        if (s == null || s.length() == 0)
            return result;
        Map<Character, Integer> map = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, i);
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            end = Math.max(end, map.get(ch));
            if (end == s.length() - 1) {
                result.add(end - start + 1);
                break;
            }
            if (i == end) {
                result.add(end - start + 1);
                start = end + 1;
            }
        }
        return result;
    }
}
