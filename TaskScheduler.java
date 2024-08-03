// Time Complexity : O(2n) -> O(n)
// Space Complexity :  O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, had to learn

/*
 * Problem# :621
 * 
 * Have to remember the formuale :)
 * 
 * We go through the tasks and get the frequencies of each task -> put them in a map
 * We go through the map and get the number of max frequencies
 * 
 * partitions = maxFreq-1;
 * availableSlots = paritions*n
 * pending = totaltaks - maxFreq
 * idle = availableslots-pending
 * 
 * 
 * partitions = maxFreq-1;
 * availableSlots = paritions* (n-maxFreqCount-1) -1 because we dont have to count the first occuerenace 
 * pending = totaltaks - (maxFreq * maxFreCount)
 * idle = availableslots-pending
 * 
 */

import java.util.*;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> cache = new HashMap<>();
        int maxFreq = 0;
        for (int i = 0; i < tasks.length; i++) {
            char c = tasks[i];
            cache.put(c, cache.getOrDefault(c, 0) + 1);
            maxFreq = Math.max(maxFreq, cache.get(c));
        }

        int maxFreCount = 0;
        for (Map.Entry<Character, Integer> kEntry : cache.entrySet()) {
            if (kEntry.getValue() == maxFreq) {
                maxFreCount++;
            }
        }

        int partitions = maxFreq - 1;
        int availableSlots = partitions * (n - (maxFreCount - 1));
        int pending = tasks.length - (maxFreq * maxFreCount);
        int idle = Math.max(0, availableSlots - pending);

        return tasks.length + idle;

    }
}
