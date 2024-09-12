// Time Complexity :O(N)
// Space Complexity :O(26)~O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] lastIndex = new int[26];
        // get last index
        
        for(int i =0;i<S.length();i++){
            lastIndex[S.charAt(i)-'a'] = i;
        }
        List<Integer> result = new LinkedList<>();
        
        
        int start = 0;
        int end = 0;
        int current =0;
        while(current<S.length()){
            char ch = S.charAt(current);
            end = Math.max(end, lastIndex[ch-'a']);
            if(current == end){
                result.add(end-start+1);
                start = current+1;
            }
            
            current++;
        }
        return result;
    }
}