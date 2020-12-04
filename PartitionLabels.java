// Time Complexity : O(S), S string length
// Space Complexity : O(1), int[26], result[] 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
// create lastIndexOfChar[] for all 26 lower case chars
// proceed from string start, mark end as lastIndexOf first char proceed till end, interim check char last occurance value, if >end update end
// end if i==end mark first partition, repeat till string end 

class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<Integer>();
        
        //base case
        if(S==null || S.length()==0) return result;
        
        int[] lastIdxOfChar = new int[26];
        
        for(int i=S.length()-1; i>=0; i--){
            if(i>lastIdxOfChar[S.charAt(i)-'a']){
                lastIdxOfChar[S.charAt(i)-'a'] = i;
            }
        }
        
        int start = 0;
        int end = lastIdxOfChar[S.charAt(start)-'a'];
        
        for(int i=0; i<S.length(); i++){
            if(i<end && lastIdxOfChar[S.charAt(i)-'a'] > end){
                end = lastIdxOfChar[S.charAt(i)-'a'];
            }
            else if(i==end){
                result.add(end-start+1);
                
                if(i+1<=S.length()-1){
                    start = i+1;
                    end = lastIdxOfChar[S.charAt(i+1)-'a'];
                }
            }
        }
        
        return result;
    }
}