/**
 * Approach: Use a HashMap to store the last index of each character to determine partition boundaries.
 * Solution: Iterate through the string, updating the current partition end to the farthest last index seen.
 * When the current index equals the partition end, close the partition and record its length.
 */
public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> hmap = new HashMap<>();

        for(int i = 0; i < s.length() ;i++) {
            char c = s.charAt(i);
            hmap.put(c,i);
        }

        List<Integer> result = new ArrayList<>();

        int start = 0;
        int end = 0; 

        for(int i = 0; i < s.length() ; i++) {
            char c = s.charAt(i);
            end = Math.max(end, hmap.get(c));
            if(i == end) {
                result.add(end-start+1);
                start = i+1;
            }
        }
        return result;
    }
}