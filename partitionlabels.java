// TC: O(n)
// SC: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    // TC = O(n), SC = O(1), use HashMap to store the farthest index, to find partition
    public List<Integer> partitionLabels(String s) {
        if(s == null || s.length() == 0) return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0, end = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, i); // recording the farthest index by traversing
        }
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            end = Math.max(end, map.get(c));
            if(i == end) { // found partition
                result.add(end - start + 1); // capture partition
                start = end + 1;
            }
        }
        return result;
    }
}