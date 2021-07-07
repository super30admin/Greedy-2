// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        if(S == null || S.length() == 0){
            return null;
        }
        HashMap<Character, Integer> lastIndex = new HashMap<>();
        for(int i=0; i<S.length(); i++){
            char c = S.charAt(i);
            lastIndex.put(c, i);
        }

        List<Integer> result = new ArrayList<>();

        int start = 0;
        int end = 0;

        for(int i = 0; i < S.length(); i++){
            char c = S.charAt(i);
            end = Math.max(end, lastIndex.get(c));

            if(i == end){
                result.add(end - start + 1);
                start = end + 1;
            }
        }
        return result;
    }
}
