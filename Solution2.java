
// Time complexity - O(n^2)
// Space - O(1) - since o/p doesn't count
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Problem2 Partition Labels (https://leetcode.com/problems/partition-labels/)
// Time - O(n)
// Space - O(26) or constant
class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        if(S == null || S.length() == 0)
            return res;
        
        HashMap<Character, Integer> lastOccurence = new HashMap<>();
        
        for(int i = 0; i < S.length(); i++){
            lastOccurence.put(S.charAt(i), i);
        }
        
        int end = 0, left = 0;
        
        for(int i = 0; i < S.length(); i++){
            char c = S.charAt(i);
            end = Math.max(end, lastOccurence.get(c));
            
            if(i == end){
                res.add(end - left + 1);
                left = i + 1;
            }
            
        }
        
        return res;        
        
    }
}