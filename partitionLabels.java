// Time Complexity : O(n)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

// Your code here along with comments explaining your approach
class Solution {
    public List<Integer> partitionLabels(String s) {
        
        int[] end = new int[26];
        
        for(int i = s.length()-1; i >= 0; i--) {
            if(end[s.charAt(i)-'a']==0) end[s.charAt(i)-'a'] = i;
        }
        
        List<Integer> ans = new ArrayList();
        int partition = 0;
        int start = 0;
        
        for(int i = 0; i<s.length(); i++ ) {
            
            if(end[s.charAt(i)-'a']>partition) partition = end[s.charAt(i)-'a'];
            if(i==partition) {
                ans.add(i-start+1);
                start=i+1;
            }
            
            
        }        
        
        return ans;
    }
}
