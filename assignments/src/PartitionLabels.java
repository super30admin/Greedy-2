// Approach: Greedy: Create a char-index map and store all the indexes (naturally, as map will
// overwrite values, last index of all the characters is stored in the map)
// Iterate over the string again with start = 0 and end = 1st characters last index "end" (get
// from map) and when i == end calculate (start - end + 1) and add to result. new start = i + 1.
// Time: O(n)
// Space: O(1) since hashmap of 26 characters only every time

import java.util.*;

class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList();
        if (s == null || s.length() == 0) return result;

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i<s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch,i);
        }

        int start = 0, end = map.get(s.charAt(0));
        for (int i = 0; i<s.length(); i++) {
            char ch = s.charAt(i);
            end = Math.max(end, map.get(ch));

            if (i == end) {
                result.add(end - start + 1);
                start = i + 1;
            }
        }
        return result;
    }
}