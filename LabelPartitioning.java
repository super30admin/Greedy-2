// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

//Time Complexity : O(n) since we are iterating through the entire string linearily twice
//Space Complexity: O(n) since we are using an extra hashmap    

class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        if(s == null || s.length() == 0) return res;
        //Map to store the character and the last index
        HashMap<Character, Integer> map = new HashMap<>();
                
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            map.put(c, i);
        }
        
        int start = 0; int end = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            end = Math.max(end, map.get(c));
            if(i == end){
                res.add(end - start + 1);
                start = end + 1;
            }
        }           
        return res;
    }
}