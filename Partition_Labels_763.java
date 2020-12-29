//Time Complexity : O(n)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : None

package com.s30.satish;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Partition_Labels_763 {
    public List<Integer> partitionLabels(String S) {
        List<Integer> list = new ArrayList<>();
        if(S == null || S.length() == 0)
            return list;
        int start = 0;
        int end = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < S.length(); i++)
        {
            map.put(S.charAt(i), i);
        }
        for(int i = 0; i < S.length(); i++)
        {
            char c = S.charAt(i);
            end = Math.max(map.get(c), end);
            if(i == end)
            {
                list.add(end - start + 1);
                start = i+1;
            }
        }
        return list;
        
//        // nArray approach uses less execution time
//        public List<Integer> partitionLabels(String S) {
//            List<Integer> list = new ArrayList<>();
//            if(S == null || S.length() == 0)
//                return list;
//            int start = 0;
//            int end = 0;
//            int[] nArray = new int[26];
//            for(int i = 0; i < S.length(); i++)
//            {
//                nArray[S.charAt(i) - 'a'] = i;
//            }
//            for(int i = 0; i < S.length(); i++)
//            {
//                char c = S.charAt(i);
//                end = Math.max(nArray[c - 'a'], end);
//                if(i == end)
//                {
//                    list.add(end - start + 1);
//                    start = i+1;
//                }
//            }
//            return list;
//        }
        
        
    }
    public static void main(String[] args)
    {
    	Partition_Labels_763 obj = new Partition_Labels_763();
    	String str = "ababcbacadefegdehijhklij";
    	System.out.print(obj.partitionLabels(str));
    	
    }
}
