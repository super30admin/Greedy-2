//TC: O(n)
//SC: O(1)
class Solution {
    public List<Integer> partitionLabels(String s) {
        // Step 1: Record the last occurrence of each character
        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        
        // Step 2: Create partitions
        List<Integer> partitions = new ArrayList<>();
        int start = 0, end = 0;
        
        for (int i = 0; i < s.length(); i++) {
            // Update the end of the partition
            end = Math.max(end, last[s.charAt(i) - 'a']);
            
            // When current index matches the end, a partition is found
            if (i == end) {
                partitions.add(end - start + 1);  // Add partition size
                start = i + 1;  // Move the start of the next partition
            }
        }
        
        return partitions;
    }
}
