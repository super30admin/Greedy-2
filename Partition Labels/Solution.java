/**
Time Complexity: O(n)
Space Complexity: O(k) - map size - no of diff characters 
Leetcode : yes
 */
class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        int partitionStart = 0;

        // store last index of each character
        for(int i=0;i<S.length();i++)
            map.put(S.charAt(i), i);
        
        int partitionEnd = 0;
        for(int i = 0;i<S.length();i++) {
            // get the last index of curr index
            partitionEnd = Math.max(partitionEnd, map.get(S.charAt(i)));
            
            // check if its the end of partition : if so add to result; start a new partition
            if(i == partitionEnd) {
                result.add(partitionEnd - partitionStart + 1);
                partitionStart = partitionEnd + 1;
                
            }
        }
        
        return result;
    }
}