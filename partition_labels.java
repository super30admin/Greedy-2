// Time Complexity : O(n) because we traverse the string twice
// Space Complexity : O(1) since the character set is bounded
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// We first record the last occurrence of every character in the string.
// While scanning the string, we keep extending the current partition to include the last occurrence of every character seen so far.
// When the current index reaches the partition end, we finalize the partition and start a new one.

class Solution {
    public List<Integer> partitionLabels(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        // record last occurrence of each character
        for(int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }

        List<Integer> res = new ArrayList<>();

        int start = 0, end = 0;

        for(int i = 0; i < s.length(); i++) {

            // extend current partition
            end = Math.max(end, map.get(s.charAt(i)));

            // partition complete
            if(i == end) {
                res.add(end - start + 1);
                start = i + 1;
            }
        }

        return res;
    }
}