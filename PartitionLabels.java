// In this problem, using a hashmap to store the character with it's farthest occurence as the value. We keep start and end, when we 
// start traversing the string, the first char, wherever it's farthest occurence is get it from map, and set our end to that index.
// Then as we move forward, check for all char it's farthest occurence index, if smaller than current end index, then update end else
// move ahead till i becomes equal to the end. Once they are equal, we find our first partition, capture length and change start to 
// end + 1 and repeat all.

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    public List<Integer> partitionLabels(String s) {
        // Base case
        if (s == null || s.length() == 0) {
            return new ArrayList<>() {
            };
        }
        // Hashmap for storing farthest occurence
        HashMap<Character, Integer> map = new HashMap<>();
        // Declare result list
        List<Integer> result = new ArrayList<>();
        // Declare start and end
        int start = 0;
        int end = 0;
        // Iterate and put in map
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, i);
        }
        // Now again iterate
        for (int i = 0; i < s.length(); i++) {
            // Take one char at a time
            char c = s.charAt(i);
            // Update end if required
            end = Math.max(end, map.get(c));
            // When i==end,
            if (i == end) {
                // Capture length of partition in result
                result.add(end - start + 1);
                // Update start
                start = end + 1;
            }
        }
        return result;
    }
}