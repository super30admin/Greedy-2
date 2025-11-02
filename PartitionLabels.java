import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//TC: O(n), SC: O(n)
public class PartitionLabels {

    public List<Integer> partitionLabels(String s) {
        final Map<Character, Integer> maxIndex = new HashMap<>();
        for (int i = 0; i < s.length(); i++) maxIndex.put(s.charAt(i), i);

        final List<Integer> output = new ArrayList<>();
        int current = 0, earlier = 0;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (current < maxIndex.get(ch)) {
                current = maxIndex.get(ch);
            }

            if (i == current) {
                output.add(current - earlier + 1);
                earlier = current + 1;
                current = maxIndex.get(ch);
            }
        }

        return output;
    }
}
