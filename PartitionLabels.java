import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PartitionLabels {
    // Time complexity - o(n)
    //space complexity o(1) because constant number of characters
    public List<Integer> partitionLabels(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }
        HashMap<Character, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        int start = 0;
        int end = 0;
        // put the lst index of each char that we will use later for partitioning
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, i);
        }
        // now get the array partition.
        //GEt the last index od first char, keep moving until end becomes equal to i and capture the length of partitioned string and add to result. next move the start to end+1 or i+1.

        for (int i = 0; i < s.length(); i++) {
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
