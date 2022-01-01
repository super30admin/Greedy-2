// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public List<Integer> partitionLabels(String S) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i< S.length();i++)
            map.put(S.charAt(i),i);

        int start = 0, end = 0;
        
        ArrayList<Integer> output = new ArrayList <>();
        
        for(int i = 0; i < S.length(); i++){
            end = Math.max(end, map.get(S.charAt(i)));
            
            if(end == i){
                output.add(end - start + 1);
                start = end + 1;
                end = start;
            }
        }
            
        return output;
    }
}