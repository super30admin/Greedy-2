// Time Complexity : O(n) where n is the length of the string s
// Space Complexity :O(1) as the hashmap would have 26 keys at the most
// Did this code successfully run on Leetcode :yes

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {

        int len = s.length();
        //create a map
        HashMap<Character, Integer> lastPositionMap = new HashMap<>();
        for(int i =0; i< len; i++){
            Character c = s.charAt(i);
            lastPositionMap.put(c, i);
        }

        int start = 0;
        int end = 0;
        List<Integer> result = new ArrayList<>();

        for(int i=0; i<len; i++){
            Character c = s.charAt(i);
            end = Math.max(end, lastPositionMap.get(c));
            if(i == end){
                result.add(end - start + 1);
                start = end +1;
            }
        }
        return result;
    }
}
