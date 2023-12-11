// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class PartitionLabel {
    class Solution {
        public List<Integer> partitionLabels(String s) {
            int sLen = s.length();
            if(sLen == 0 || s == null)
                return new ArrayList<>();

            Map<Character, Integer> map = new HashMap<>();
            for(int i = 0; i < sLen; i++){
                char c = s.charAt(i);
                map.put(c, i);
            }

            int start = 0, end = 0;
            List<Integer> result = new ArrayList<>();

            for(int i = 0; i < sLen; i++){
                char c = s.charAt(i);
                int currEnd = map.get(c);
                end = Math.max(end, currEnd);
                if(i == end){
                    result.add(end - start + 1);
                    start = i+1;
                }
            }
            return result;
        }
    }
}
