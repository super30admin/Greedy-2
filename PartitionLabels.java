// Time Complexity : O(n) --> where n is the length of the input string
// Space Complexity : O(1)
// Did this code successfully run on Leetcode (763): Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();
        
        // edge case
        if (S == null || S.length() == 0) return result;
        
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            map.put(c, i);
        }
        
        int start = 0; int end = 0;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            end = Math.max(end, map.get(c));
            if (i == end) {
                result.add(end - start + 1);
                start = end + 1;
            }
        }
        return result;
    }
}