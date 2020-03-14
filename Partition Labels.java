// Time Complexity : O(n)
// Space Complexity : 0(1) max alphapbets worst case would be 26 for the HASH map
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Your code here along with comments explaining your approach

class Solution {
    public List<Integer> partitionLabels(String S) {
        int [] map = new int [26]; //max possible alphabets
    
        //map indices are basically the alphabets a-z
        //Populate map with farthest index of the character
        for(int i=0; i<S.length(); i++) {
            char c= S.charAt(i);
            map[c- 'a'] = i;
        }
        
        int start = 0; int end =0;
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<S.length(); i++) {
            char c = S.charAt(i);
            end = Math.max(end, map[c-'a']); //update the end for thr partition with farthest index
            if(end == i) {
                result.add(end - start +1); //Add length of partition to the result
                start = end + 1; // reset start to index just after the current partition
            }
        }
              return result;
    }
}
