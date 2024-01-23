package PartitionLabels;

import java.util.*;

// Time Complexity : O(2n) -> O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/** Using array */

class Solution {
    public List<Integer> partitionLabels(String s) {

        int[] arr = new int[26];
        List<Integer> result = new ArrayList<>();

        int n = s.length();
        for (int i = 0; i < n; i++) {
            arr[s.charAt(i) - 'a'] = i;
        }

        int min = 0, max = 0;

        for (int i = 0; i < n; i++) {
            int freq = arr[s.charAt(i) - 'a'];
            if (freq > max)
                max = freq;

            if (max == i) {
                result.add(max - min + 1);
                min = i + 1;
            }
        }

        return result;
    }
}

/** Using HashMap */

class Solution {
    public List<Integer> partitionLabels(String s) {

        HashMap<Character, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        int n = s.length();
        for (int i = 0; i < n; i++) {
            map.put(s.charAt(i), i);
        }

        int min = 0, max = 0;

        for (int i = 0; i < n; i++) {
            int freq = map.get(s.charAt(i));
            if (freq > max)
                max = freq;

            if (max == i) {
                result.add(max - min + 1);
                min = i + 1;
            }
        }

        return result;
    }
}