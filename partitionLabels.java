/*
Problem: https://leetcode.com/problems/partition-labels/
TC: O(n)
SC: O(1) -> map stores 26 lower case letters at max
*/
class Solution {
    public List<Integer> partitionLabels(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }
        
        HashMap<Character, Integer> charIndexMap = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            charIndexMap.put(s.charAt(i), i);
        }
        
        List<Integer> partitions = new ArrayList<>();
        for (int i = 0; i < s.length();) {
            int windowStart = i;
            int windowEnd = charIndexMap.get(s.charAt(i));
            
            while (i <= windowEnd) {
                windowEnd = Math.max(windowEnd, charIndexMap.get(s.charAt(i)));
                ++i;
            }
            partitions.add(windowEnd - windowStart + 1);
        }
        
        return partitions;
    }
}