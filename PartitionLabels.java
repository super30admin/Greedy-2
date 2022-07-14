// Time Complexity : O(N)
// Space Complexity : O(1), map of constant chars 26 or 256
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class PartitionLabels {
    class Solution {
        public List<Integer> partitionLabels(String s) {
            Map<Character, Integer> lastIndexMap = new HashMap<>();
            for(int i=0; i<s.length(); i++) {
                lastIndexMap.put(s.charAt(i),i);
            }

            int start = 0;
            int end = 0;
            List<Integer> result = new ArrayList<>();
            for(int i=0; i<s.length(); i++) {
                char c = s.charAt(i);
                end = Math.max(end, lastIndexMap.get(c));
                if(i == end) {
                    result.add(end - start +1);
                    start = i +1;
                }
            }
            return result;
        }
    }
}
