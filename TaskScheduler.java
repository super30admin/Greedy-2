/*
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(n)
* 
* Space Complexity: O(1)
* 
*/

import java.util.HashMap;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> hmap = new HashMap<>();

        int maxFreq = 0;

        for (char task : tasks) {
            hmap.put(task, hmap.getOrDefault(task, 0) + 1);

            maxFreq = Math.max(maxFreq, hmap.get(task));
        }

        int sameFreqElements = 0;

        for (char key : hmap.keySet()) {
            if (hmap.get(key) == maxFreq) {
                sameFreqElements++;
            }
        }

        int partitions = maxFreq - 1;

        int availableSlots = partitions * (n - (sameFreqElements - 1));

        int pendingTasks = tasks.length - maxFreq * sameFreqElements;

        int idleSlots = Math.max(0, availableSlots - pendingTasks);

        return tasks.length + idleSlots;
    }
}
