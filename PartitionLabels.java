// Time Complexity : O(2n) -> O(n)
// Space Complexity : O(1) Since at the max only 26 characters will be stored in hash map.
// Did this code successfully run on Leetcode : Yes

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        List<Integer> li = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++)  // O(n)
        {
            char c = s.charAt(i);
            map.put(c,i);
        }

        int start = 0, end = 0;
        for(int i=0; i<s.length(); i++){  // O(n)
            char c = s.charAt(i);
            end = Math.max(end,map.get(c));
            if( i == end)
            {
                li.add(end - start + 1);
                start = i +1;
            }
        }

        return li;
    }
}
