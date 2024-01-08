// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


// Your code here along with comments explaining your approach

class Solution {
    public List<Integer> partitionLabels(String s) {

        int[] last = new int[26];
        for(int i = 0; i < s.length(); i++){
            last[s.charAt(i) - 'a'] = i;
        }
        List<Integer> result = new ArrayList<>();
        int start = 0;
        int end = 0;

        for(int i = 0; i < s.length(); i++){
            end = Math.max(end, last[s.charAt(i) - 'a']);
            if(i == end){
                result.add(end - start + 1);
                start = i + 1;
            }
        }
        return result;
    }
}