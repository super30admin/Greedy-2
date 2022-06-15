// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }
        
        int start = 0, end = 0;
        List<Integer> result = new ArrayList<>();
        
        for(int i = 0; i < s.length(); i++) {
            end = Math.max(end, map.get(s.charAt(i)));
            if(i == end) {
                result.add(end - start + 1);
                start = end + 1;
            }
            
            
        }
        
        return result;
    }
}