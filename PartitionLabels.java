/*
 * TC: O(n)
 * SC: O(n)
 */
import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        int[] charMap = new int[26];
        // update the map with the last index of each character
        for (int i = 0; i < s.length(); i++) {
            charMap[s.charAt(i) - 'a'] = i;
        }
        List<Integer> result = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            // update end for each char as max(end, lastIndexOf(char))
            end = Math.max(end, charMap[s.charAt(i) - 'a']);
            // if the current index is the lastIndex, we've found
            // a block. add to result and set start
            if (end == i) {
                result.add(end - start + 1);
                start = i + 1;
            }
        }
        return result;
    }
}