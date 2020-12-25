package Dec24;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class PartitionLabels {
	
    public List<Integer> partitionLabels(String S) {
        
        // Time complexity: O(n) + O(n) ~= O(n)
        // Space complexity: O(1) because hashmap is extra additional space that we are using and it will contain at max 26 characters, hence constt.space.
        
        /*
Approach:
Find last occurrence of first character of string and that can be identified as the first partition from start to last occurrence of first character index. Now we should check if all characters between this start and end have their last occurrences within this window itself or beyond it. If beyond, we need to update end to the beyond index. If not, keep checking till we reach end of the first partition. 

Now we need to start checking for second partition which will start after end of first partition, so reset start = end+1. Repeat the process as mentioned earlier.

This will be repeated till we reach end of given string S.
        
        */
        
        List<Integer> result = new ArrayList<>();
        
        //edge
        if (S == null || S.length() == 0) {
            return result;
        }
        
        // hashmap stores last index of every character
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < S.length(); i++) { // O(n)
            char c = S.charAt(i);
            map.put(c, i);
        }
        
        // identifying partitions
        int start = 0 , end = 0;
        
        for(int i = 0; i < S.length(); i++) { // O(n)
            char c = S.charAt(i);
            end = Math.max(end, map.get(c));
            if (i == end) {
                result.add(end-start+1);
                start = end + 1;
            }
        }
        
        return result;
        
    }
}