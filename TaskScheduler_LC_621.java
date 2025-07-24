/*
Did this code successfully run on Leetcode :  Yes
Any problem you faced while coding this :  No

Time Complexity - O(N) to build map
Space Complexity - O(1)
Approach - Build map for frequencies
Calculate Below :
1)  partition - will be highest Frequency - 1 because last frquency will be taken care.
Bottleneck Scenarios like multiple same frequencies in that case club "SameFrequencyCounts" together. we need this clubbing to derive Available slots.
2) Available - partition * (n - (SameFrequencyCounts -1)) // if we dont club maxNumFrequcny we will get incorrect available slots.
e.g 4-A, 4-B, 4- C we have SameFrequencyCounts = 3 and maxFrequncy = 4
3)  Pending  - lenght of Array - (SameFrequencyCounts * maxFrequncy)
4) Idle - Max(0, available - pending)
at the end return length of array + Idle
*/

import java.util.HashMap;
import java.util.Map;
public class TaskScheduler_LC_621 {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        // Step 1: Build frequency map
        for (char task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }

        // Step 2: Find max frequency and how many tasks have it
        int maxFrequency = 0;
        for (int freq : map.values()) {
            maxFrequency = Math.max(maxFrequency, freq);
        }

        int maxFreqCount = 0;
        for (int freq : map.values()) {
            if (freq == maxFrequency) {
                maxFreqCount++;
            }
        }

        int partitions = maxFrequency -1;
        int available = partitions *(n-(maxFreqCount-1));
        int pending = tasks.length - (maxFreqCount * maxFrequency);
        int idle = Math.max(0, available - pending);

        return tasks.length + idle;

    }
}