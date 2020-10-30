    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/partition-labels/
    Time Complexity for operators : o(2n) .. n is string length
    Extra Space Complexity for operators : o(1) .. hashmap of constant size
    Did this code successfully run on Leetcode : NA
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : 
        # Optimized approach: 
                              
            # 1. 
                    A) 
    */ 
class Solution {
    public List<Integer> partitionLabels(String S) {
        
        if(S.length() == 0 || S == null)
            return new ArrayList<>();
        
        HashMap<Character, Integer> hm = new HashMap<>(26);
        int start = 0, end = 0;
        for(int i=0;i<S.length();i++){
            char ch = S.charAt(i);
            hm.put(ch,i);
        }
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<S.length();i++){
            char ch = S.charAt(i);
            
            if(end < hm.get(ch)){
                end = hm.get(ch);
            }
            
            if(i == end){
                list.add(end-start+1);
                start = i + 1;
            }
            
        }
        return list;
    }
}