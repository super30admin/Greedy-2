// Time Complexity : O(n)
// Space Complexity : O(1) as we have constant number of characters
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
Approach: We will first use hashmap to store the character and index of the last occurance of that character. Then iterate over the string with 2 pointers: start = 0 & end = 0. Then fetch the value from the map for that character and update end which is max of current end and the existing end. If end == i, then store in the result and update the resultant list by calculating end - start + 1.
 */
class Solution {
    public List<Integer> partitionLabels(String s) {

        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }

        HashMap<Character, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            map.put(c, i);
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            end = Math.max(end, map.get(c));

            if (end == i) {
                result.add(end - start + 1);
                start = end + 1;
            }
        }

        return result;
    }
}