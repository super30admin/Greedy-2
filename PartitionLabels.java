// Time Complexity : O(n)
// Space Complexity : O(1) - 26 characters only
// Did this code successfully run on Leetcode : yes

// Approach: Find the end index of each character to calculate the partition.

class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        Map<Character,Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            map.put(c, i);
        }

        int st = 0;
        int end = 0;

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            end = Math.max(end, map.get(c));

            if(i == end){ // found the partition
                result.add(end - st + 1);
                st = i+1;
            }
        }

        return result;
    }
}