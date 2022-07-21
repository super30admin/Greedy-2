package com.interview.s30.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode 763: https://leetcode.com/problems/partition-labels/
 *
 * Input: s = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 *
 * LowerCase Letters Only
 *
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
 */
public class PartitionLabels {

    public List<Integer> partitionLabels(String s) {

        List<Integer> output = new ArrayList<>();

        int lastOccurence[] = new int[26];
        int length = s.length();

        for(int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            int hashValue = ch - 'a';
            lastOccurence[hashValue] = i;
        }

        int start = 0;
        int end = 0;

        for(int i =0; i < length; i++) {

            char ch = s.charAt(i);
            int hashValue = ch - 'a';
            int last = lastOccurence[hashValue];

            end = Math.max( end, last);

            if( i == end ) {
                output.add(end - start + 1);
                start = end + 1;
            }
        }

        return output;

    }
}
