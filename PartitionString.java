/*
Time: O(S) where S is length of String
Space: O(1) a-z (26 is constant)
Approach:
========
1. Find last occurrences of each character and update in array
2. Keep track of start and end of partition by continuously updating end when iterating through array
3. Once end equals current index, there is no character in partition which repeats in reminder of string
and we found end of a partition
4. Add partition length to result and do it for remaining partitions
*/

class Solution {
    public List<Integer> partitionLabels(String S) {
        if(S == null || S.length() == 0) return new ArrayList<Integer>(); 
        
        List<Integer> result = new ArrayList<Integer>(); 
        int[] lastIndex = new int[26]; 
        // get last index of every character and update in array
        for(int i = 0; i < S.length(); i++) {
            lastIndex[S.charAt(i)-'a'] = i;
        }
        
        int start = 0,  end = 0; 
        //Find partitions based on last indices 
        for(int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i); 
            //update end of current partition
            end = Math.max(end, lastIndex[ch - 'a']); 
            
            // if current end value is equal to index, this can be end of one partition
            if(i == end) {
                // total elements is end - start + 1
                result.add(end - start + 1); 
                // update start of next partition
                start = i+1;
            }
        }
        return result;
    }
}