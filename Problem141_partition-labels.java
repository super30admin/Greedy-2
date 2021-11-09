// Time Complexity: O(n)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public List<Integer> partitionLabels(String s) {
        if(s == null || s.length() == 0) return new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        List<Integer> li = new ArrayList<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, i);
        }
        int start = 0; 
        int end = map.get(s.charAt(0));
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            end = Math.max(end, map.get(c));
            if(i == end) {
                // record the length
                li.add(i - start + 1);
                start = i + 1;
            }
        }
        return li;
    }
}