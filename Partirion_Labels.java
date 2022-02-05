// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach

// We do this using Greedy approach
// We get the last occurrence by putting in the map
// we take start and end
// when we get i == end, we add the index to the result

class Solution {
    public List<Integer> partitionLabels(String s) {
        if (s.length() == 0 || s == null)
            return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, i);
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            end = Math.max(end, map.get(c));
            if (i == end) {
                result.add(end - start + 1);
                start = end + 1;
            }
        }
        return result;
    }
}