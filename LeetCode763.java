// Time Complexity : O(n) // going over the  n array elements twice
// Space Complexity : O(1) // map can have atmost 26 characters
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<Integer>();
        HashMap<Character, Integer> map = new HashMap<>();
        //Store the last index of the characters
        for(int i =0; i<s.length();i++){
            char c = s.charAt(i);
            map.put(c,i); 
        }
        int start = 0, end = 0;
        for(int i =0; i<s.length();i++){
            char c = s.charAt(i);
            // find if end is greater or if any char has greater index than end b/w start and end 
            end = Math.max(end, map.get(c));
            // if end is equal to current index that means that is one partition
            if(end == i){
                result.add(end-start+1); // so add partition to result
                start = end +1; // update start
            }
        }
        return result;
    }
}