import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> lastOccMap = new HashMap<>();
        for(int i = 0 ; i < s.length(); i++)
        {
            lastOccMap.put(s.charAt(i), i);
        }
        int start = 0, end = 0;
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < s.length(); i++)
        {
            char currChar = s.charAt(i);
            int lastOcc = lastOccMap.get(currChar);
            end = Math.max(end, lastOcc);
            if(i == end)
            {
                result.add(end-start + 1);
                start = i+1;
            }
        }

        return result;
    }
}