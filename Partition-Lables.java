// Time Complexity : O(N)

// Space Complexity : O(N)

// Did this code successfully run on Leetcode : YES

// Appoarch: Using Greedy, find the last of a char. \check if i reaches end and find the diff.
// return res.

// 763. Partition Labels

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            map.put(c,i);
        }
        int start = 0,end =0;
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            end = Math.max(end,map.get(c));
            if(i == end){
                res.add(i - start + 1);
                start = i+1;
            }
        }
        return res;
    }
}