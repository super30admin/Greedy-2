//Time = O(n), length of input
//Space = O(1)

class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] lastIndices = new int[26]; // array to store last index of each character
        for (int i = 0; i < s.length(); i++) {
            lastIndices[s.charAt(i) - 'a'] = i;
        }
        
        List<Integer> partitions = new ArrayList<>(); // list to store partition lengths
        int start = 0, end = 0; // pointers to mark the start and end of a partition
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, lastIndices[s.charAt(i) - 'a']); // update end pointer
            
            if (i == end) { // if current index is equal to end pointer
                partitions.add(end - start + 1); // add partition length to list
                start = end + 1; // move start pointer to next index
            }
        }
        
        return partitions;
    }
}
