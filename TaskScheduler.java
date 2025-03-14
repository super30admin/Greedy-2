//TC: O(n)
//SC: O(1) as maximum 26 entries in hashmap
//approach: store frequencies in map, calculate idle slots using maxFrequency and count of tasks having max frequency

import java.util.HashMap;

public class TaskScheduler {
    public static int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxCount = 0 , maxFreq = 0;

        for (char task : tasks) {
            if (map.containsKey(task)) {
                int count = map.get(task) + 1;
                if (count > maxFreq) {
                    maxFreq = count;
                }
                map.put(task, count);
            } else {
                map.put(task, 1);
            }
        }

        for(int val : map.values()) {
            if(val == maxFreq) {
                maxCount++;
            }
        }

        int partitionCount = maxFreq - 1;
        int emptySlots = (n - (maxCount - 1)) * partitionCount;
        int pendingTasks = tasks.length - (maxCount * maxFreq);
        int idleSlots = Math.max(0, emptySlots - pendingTasks);
        return tasks.length + idleSlots;
    }
}
