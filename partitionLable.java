// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        if(S.length() == 1)
        {
            res.add(1);
            return res;
        }
        
        Map<Character, Integer> mp = new HashMap<>();
        
        for(int i=0;i< S.length();++i)
            mp.put(S.charAt(i), i);
        
        int end = -1;
        
        int start = 0;
        
        for(int l = 0; l < S.length(); ++l)
        {
            char c = S.charAt(l);
            
            int k = mp.get(c);
            end = Math.max(end, k);
                
            if(l == end)
            {
                res.add(end - start + 1);
                start = end+1;
            }
            
        }
        
        return res;
    }
}