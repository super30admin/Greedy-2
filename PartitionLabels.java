//  Time Complexity: O(n)
//  Space Complexity: O(1)

import java.util.*;

public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            map.put(c, i);  //  this will always be the last index for that char
        }

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            end = Math.max(end, map.get(c));

            if (i == end) {
                result.add(end - start + 1);
                start = end + 1;
            }
        }

        return result;
    }
}
