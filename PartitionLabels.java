import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {
    // TC: O(N) where N is length of S
    // SC: O(1)
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> lastPos = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            lastPos.put(s.charAt(i), i);
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, lastPos.get(s.charAt(i)));
            if (i == end) {
                res.add(end - start + 1);
                start = end + 1;
            }
        }
        return res;
    }
}
