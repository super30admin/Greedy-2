package greedy2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {
	//Using Array
	//Time Complexity : O(n), where n is the length of string s
	//Space Complexity : O(1)
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        // null
        if(s == null || s.length() == 0)
            return res;
        
        int[] count = new int[26];
        for(int i=0; i<s.length(); i++)
            count[s.charAt(i) - 'a'] = i;
        
        int start = 0;
        int maxIndex = 0;
        for(int i=0; i<s.length(); i++) {
            maxIndex = Math.max(maxIndex, count[s.charAt(i) - 'a']);
            if(i == maxIndex) {
                res.add(i - start + 1);
                start = i + 1;
            }
        }
        
        return res;
    }
	
	//Using Map
	//Time Complexity : O(n), where n is the length of string s
	//Space Complexity : O(1)
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public List<Integer> partitionLabels1(String s) {
        List<Integer> res = new ArrayList<>();
        // null
        if(s == null || s.length() == 0)
            return res;
        
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++)
            map.put(s.charAt(i), i);
        
        int start = 0;
        int maxIndex = 0;
        for(int i=0; i<s.length(); i++) {
            maxIndex = Math.max(maxIndex, map.get(s.charAt(i)));
            if(i == maxIndex) {
                res.add(i - start + 1);
                start = i + 1;
            }
        }
        
        return res;
    }
}
