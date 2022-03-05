//Time complexity : O(n)
//Space Complexity : O(1)
//Did it run on leetcode : yes

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabel {

    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        //null case
        if(s == null || s.length() == 0) return result;

        //to maintain last index of characters
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0;i < s.length();i++){
            map.put(s.charAt(i),i);
        }

        int start = 0; int endOfWindow = 0;
        for(int i = 0;i < s.length();i++){
            char c = s.charAt(i);
            endOfWindow = Math.max(endOfWindow, map.get(c));

            if(i == endOfWindow){
                result.add(endOfWindow - start + 1);
                start = i + 1;
            }
        }
        return result;
    }

}
