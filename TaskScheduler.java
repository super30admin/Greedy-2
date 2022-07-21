package com.interview.s30.greedy;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 621. Task Scheduler
 * https://leetcode.com/problems/task-scheduler/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
 */
public class TaskScheduler {

    public int leastInterval(char[] tasks, int n)
    {

        int maxCount = 0;
        int maxFrequency = 0;

        Map<Character, Integer> map = new HashMap<>();

        for(char ch: tasks){
            map.put(ch, map.getOrDefault(ch, 0) +1);
            maxFrequency = Math.max(maxFrequency, map.get(ch));
        }

        for(char ch: map.keySet()) {
            if(map.get(ch) == maxFrequency) {
                maxCount++;
            }
        }

        int partitions = maxFrequency -1;
        int available = partitions * (n-(maxCount-1));
        int pending = tasks.length - maxFrequency*maxCount;
        int idle = Math.max(0, available-pending);

        return tasks.length + idle;


    }
}
