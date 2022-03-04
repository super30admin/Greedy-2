import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Time Complexity : Add : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class PartitionLabels {
    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        partitionLabels(s);
    }

    public static List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();

        if(s == null || s.length() == 0)
            return result;

        Map<Character, Integer> map = new HashMap<>();

        // maintain map to find the last occurance of the character
        for(int i=0; i<s.length(); i++){  // T.C - O(N) ; S.C - O(1)
            char ch = s.charAt(i);
            map.put(ch, i);
        }

        int start = 0, end = 0;

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            end = Math.max(end, map.get(ch));  // to maintain the partition
            if(i == end){
                result.add(end-start+1);
                start = i+1;  // go for the next partition
            }
        }

        return result;

    }
}

