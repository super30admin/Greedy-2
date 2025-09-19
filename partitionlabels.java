// Time Complexity: O(n) — one pass to record last indices and one pass to form partitions.
// Space Complexity: O(k) — map of last positions for up to k distinct chars (for lowercase letters, k=26 ⇒ O(1)).

// Build a map of each character’s last index in the string.
// Scan left to right, extending the current segment’s end to max(end, lastIndex[c]).
// When i == end, close the partition (size = end - start + 1), record it, and set start = i + 1.

class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            map.put(c, i);
        }

        List<Integer> result = new ArrayList<>();

        int start = 0, end = 0;

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            end = Math.max(end , map.get(c));

            if(i == end){
                result.add(end - start + 1);
                start = i + 1;
            }
        }

        return result;
    }
}
