// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// 3 pointers
class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
       if(S==null || S.length()==0)
           return res;
        
        int[] letters = new int[26];
        for(int i=0; i<S.length(); i++){
            char c = S.charAt(i);
            letters[c-'a'] = i;
        }
        
        int start =0;
        int end = 0;
        
        for(int index=0; index<S.length(); index++){
            end = Math.max(end, letters[S.charAt(index)-'a']);
            
            if(index==end){
                res.add(end - start + 1);
                start = end+1;
            }
        }
        return res;   
    }
}