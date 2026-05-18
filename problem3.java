import java.util.*;

class Solution {

    /**
    Time Complexity : O(N)
    Explanation:
    We scan the string once to store last occurrence of each character,
    then scan again to create partitions.

    Space Complexity : O(1)
    Explanation:
    HashMap stores at most 26 lowercase English letters.

    Did this code successfully run on LeetCode : Yes

    Any problem you faced while coding this :
    Initially confused about where a partition should end.
    Fixed it by storing the last index of every character.
    While scanning, keep updating the partition end as the farthest
    last occurrence of characters seen so far.
    When current index reaches end, we close the partition.
    */

    public List<Integer> partitionLabels(String s) {

        List<Integer> result = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();

        // Store last occurrence of each character
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, i);
        }

        int start = 0;
        int end = 0;

        // Build partitions
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            end = Math.max(end, map.get(c));

            if (i == end) {
                result.add(end - start + 1);
                start = i + 1;
            }
        }

        return result;
    }
}