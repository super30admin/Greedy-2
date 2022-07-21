package com.interview.s30.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 406. Queue Reconstruction by Height
 * https://leetcode.com/problems/queue-reconstruction-by-height/
 * Time Complexity : O(NlogN)
 * Space Complexity : O(1)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
 */
public class QueueConstruction
{
    public int[][] reconstructQueue(int[][] people)
    {
        List<int[]> list = new ArrayList<>();

        /**
         * here sorting the input array such that the people greater height comes first
         * and if the height is same then sort according to the frequency
         */
        Arrays.sort(people, (a,b)-> {
            if(a[0] == b[0]) {
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });

        for(int person[]: people) {
            list.add(person[1], person);
        }

        return list.toArray(people);
    }
}
