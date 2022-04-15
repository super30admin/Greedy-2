//  Time Complexity: O(n)
//  Space Complexity: O(1)

import java.util.*;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();

        int maxFreq = 0;
        for (char task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(task));
        }

        //  tasks with this max frequency
        int maxCount = 0;
        for (int val : map.values()) {
            if (val == maxFreq) {
                maxCount++;
            }
        }

        int partitions = maxFreq - 1;
        int availableSlots = partitions * (n - (maxCount - 1));
        int pendingTasks = tasks.length - (maxFreq * maxCount);
        int idles = Math.max(0, availableSlots - pendingTasks);
        return tasks.length + idles;
    }
}
