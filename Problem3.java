// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/**
 * Store the last index of each element in the input string.
 * Start iterating the the chars in the string and greedily set the partition to the last index of current character till we reach that character during this iteration.
 * If there was another char with higher end index, then we have to expand the current partition till last occurence of this char.
 * Otherwise finalize this partition and create a new partition.
 */
class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }

        List<Integer> result = new ArrayList<>();
        int end = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, map.get(s.charAt(i)));
            if (i == end) {
                result.add(end - start + 1);
                start = i + 1;
            }
        }

        return result;
    }
}