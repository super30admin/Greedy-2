// TC: O(n)
// SC: O(n)

// Approach: Store the last index of each character. Keep
// extending the window till you reach that final index.
// If there's any element with further final index, update it
// and keep going till you reach that final index.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();

        if (s.length() == 0) {
            return res;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }

        int startIndex = 0;

        while (startIndex < s.length()) {
            int i = startIndex;
            int endIndex = map.get(s.charAt(startIndex));

            while (i != endIndex) {
                if (map.get(s.charAt(i)) > endIndex) {
                    endIndex = map.get(s.charAt(i));
                }
                i++;
            }

            res.add(endIndex - startIndex + 1);
            startIndex = i + 1;
        }
        return res;
    }
}