// Time Complexity : O(2n) -> O(n)
// Space Complexity :  O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, had to learn

/*
 * Problem# :763 
 * We are trying to make a partition, and our partition depends on the longest index available..
 * so, we parse through the string once and get the last known index of a character.
 * as we move through the string the second time, we can adjust our end index based on the last known index of the character (which probably be the partition)
 * once the i reaches the end index ...we found a partition and add to result and then set the start to the next index. and move on.
 */

import java.util.*;

public class PartitionLabels {

    // using HashMap
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> cache = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            cache.put(c, i);
        }

        int start = 0;
        int end = 0;
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            end = Math.max(cache.get(c), end);
            if (i == end) {
                result.add(end - start + 1); // add +1 when working with indexes but want go get length
                start = i + 1;
            }

        }

        return result;
    }

    // using int[] as cache
    public List<Integer> partitionLabels_intA(String s) {
        int[] cache = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            cache[c - 'a'] = i;
        }

        int start = 0, end = 0;
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            end = Math.max(end, cache[c - 'a']); // cannot use ['a'-c] since it will give a -ve number and search would
                                                 // be out of index; we have to use [c-'a']
            if (i == end) {
                // the below order matters since we are working with the parameters we are
                // trying to manipulate
                result.add(end - start + 1);
                start = i + 1;

            }
        }

        return result;
    }
}
