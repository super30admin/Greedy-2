// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Store the last index of each character in a hashmap/int[]
// We fix the start and end of the current partition
// If the elements within the partition extends beyond the current end, we update the end
// If the current index reaches the end, we add the partition size to the result and start a new partition

class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList();

        HashMap<Character, Integer> map = new HashMap();
        for (int i = 0; i < s.length(); i++)
            map.put(s.charAt(i), i);
        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, map.get(s.charAt(i)));
            if (i == end) {
                res.add(end - start + 1);
                start = end + 1;
            }
        }

        return res;
    }
}