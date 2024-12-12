Time Complexity (TC): O(n), where n is the length of the string s, as we iterate through the string twice (once for building the map and once for finding partitions).
Space Complexity (SC): O(1), since the space for the map is bounded by the number of distinct characters (at most 26 for lowercase English letters), and the result list stores partition sizes.

class Solution {
    public List<Integer> partitionLabels(String s) {
        // Step 1: Create a map to store the last occurrence of each character in the string
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);  // Store the last position of each character
        }
        
        // Step 2: Initialize the result list and two pointers, start and end
        List<Integer> res = new ArrayList<>();
        int start = 0;  // Marks the start of a partition
        int end = 0;    // Marks the end of a partition
        
        // Step 3: Iterate through the string to determine partitions
        for (int i = 0; i < s.length(); i++) {
            // Update the end pointer to the furthest last occurrence of the current character
            end = Math.max(end, map.get(s.charAt(i)));
            
            // If the current index reaches the end pointer, it means we have found a partition
            if (i == end) {
                // Add the length of the current partition to the result list
                res.add(i - start + 1);
                
                // Move the start pointer to the next index after the current partition
                start = i + 1;
            }
        }
        
        // Step 4: Return the list of partition sizes
        return res;
    }
}
