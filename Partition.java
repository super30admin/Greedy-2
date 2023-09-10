// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * First iterate and keep a track of all possible lastIndexes in hashmap here I used an array for this as there are only 26 alphabets
 * First we keep track of last index of current character and keep on iteration until we reach that index and update last index if any character in between has last index higher.
 */

import java.util.*;
 class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] map = new int[26];
        for(int i=0; i< s.length(); i++){
            int index = s.charAt(i) - 'a';
            map[index] = i; 
            System.out.println("ci: " + index + " loc: "+ i);
        }
        int cm = map[s.charAt(0) - 'a'];
        int start = 0;
        List<Integer> result = new ArrayList<>();
        for(int i=0; i< s.length() - 1; i++){
            int li = map[s.charAt(i) - 'a'];
            if(i == cm){
                int size = i - start + 1;
                result.add(size);
                start = i + 1;
                cm = map[s.charAt(i + 1) - 'a'];
            }
            else {
                cm = cm > li ? cm : li;
            }
            
        }
        result.add(s.length() - start);
        return result;
    }
}