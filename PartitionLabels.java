// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>();
        // keep track of every character's last occurence in map
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            map.put(c, i);
        }
        int start = 0;
        int end = 0;
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            // we take the max at every iteration
            // will validate if every other character within that window, resides only in that window
            // if so, then we consider it as a partition
            end = Math.max(end, map.get(c));
            if(i==end) {
                res.add(end-start+1);
                start = i+1;
            }
        }
        return res;
    }
}