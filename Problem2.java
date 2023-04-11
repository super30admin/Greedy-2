import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/*
Partition Labels
approach: if we observe clearly, we see that for all characters to lie in single window, we need where each character last occurs
time: O(n)
space: O(1)
 */
public class Problem2 {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> lastIndexMap = new HashMap<Character, Integer>();
        char[] array = s.toCharArray();

        for(int i = 0; i < array.length; i++) {
            lastIndexMap.put(array[i], i);
        }

        List<Integer> partitions = new ArrayList<Integer>();

        for (int i = 0; i < array.length; i++) {
            int partitionEnd = lastIndexMap.get(array[i]);
            for(int j = i; j < partitionEnd; j++) {
                int nextLetterEnd = lastIndexMap.get(array[j]);
                if (nextLetterEnd > partitionEnd) {
                    partitionEnd = nextLetterEnd;
                }
            }
            partitions.add(partitionEnd - i + 1);
            i = partitionEnd;
        }

        return partitions;
    }
}
