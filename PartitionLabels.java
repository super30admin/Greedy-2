import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {
    // TC : O(n) n - input string length
    // SC : O(1)
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        if(s == null || s.length() == 0 ) return result;

        // This will put the mapping of a character, and it's last occurrence in the given string
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, i);
        }

        int start = 0, end = 0;
        for(int i=0; i < s.length(); i++) {
            char c = s.charAt(i);
            end = Math.max(end, map.get(c));

            // if the current i equals end value then add it to the result list
            if(i == end){
                result.add(end - start + 1);
                start = end + 1; // reset the start position
            }
        }
        return result;
    }
}
