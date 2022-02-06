// Time Complexity = O(n)
// Space Complexity = O(1)  since map will take max 26 elements
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0) return result;
        int n = s.length();

        HashMap<Character, Integer> map = new HashMap<>();

        // fill the hashmap with the last occurance of the char
        for (int i=0; i<n; i++) {
            map.put(s.charAt(i), i);
        }

        int start = 0, end = 0;
        for (int i=0; i<n; i++) {
            char c = s.charAt(i);
            end = Math.max(end, map.get(c));        // check if we find a bigger end at each char at i
            if (i == end) {
                result.add(end-start+1);
                start = end+1;
            }
        }

        return result;
    }
}