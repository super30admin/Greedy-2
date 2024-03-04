/*
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(2n)
* 
* Space Complexity: O(1)
* 
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> hmap = new HashMap<>();

        // last occurrence of each character
        for(int index = 0; index < s.length(); index++){
            char ch = s.charAt(index);

            hmap.put(ch, index);
        }

        List<Integer> result = new ArrayList<>();

        int partitionEnd = 0, partitionStart = 0;

        for(int index = 0; index < s.length(); index++){
            char ch = s.charAt(index);

            partitionEnd = Math.max(partitionEnd, hmap.get(ch));

            if(index == partitionEnd){
                result.add(partitionEnd - partitionStart + 1);
                partitionStart = index + 1;
            }
        }

        return result;
    }
}