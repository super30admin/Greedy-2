// Time Complexity : O(n) where n is length of string
// Space Complexity : O(n) map of last index of a char
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

import java.util.*;

class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();

        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            map.put(c, i);
        }
        int start = 0;
        int end = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            end = Math.max(end, map.get(c));
            if(i == end){
                result.add(end-start+1);
                start = i+1;
            }
        }

        return result;
    }

    public static void main(String [] args){
        PartitionLabels pl = new PartitionLabels();
        System.out.println(pl.partitionLabels("ababcbacadefegdehijhklij"));
    }
}