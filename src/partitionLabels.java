// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


/**
 * https://leetcode.com/problems/partition-labels//
 *
 *
 */
class Solution {
    public List<Integer> partitionLabels(String S) {
        
        if(S == null || S.length() == 0) return new ArrayList<>();
        
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        
        //maintain char and its max index
        for(int i=0; i<S.length(); i++) {
            char c = S.charAt(i);
            map.put(c,i);
        }
        
        //start and end locations of the partition
        int end = 0, start = 0;
       
        for(int i=0; i<S.length();i++) {
            char c = S.charAt(i);
            //if current character is found at location > current end, increase end, because
            // we want that character in current partition
            end = Math.max(end, map.get(c));
            
            //we reach end, add partition to result and reset start to end + 1
            if(i == end) {
                res.add(end - start + 1);
                start = end + 1;
            }
        }
        
        return res;
    }
}