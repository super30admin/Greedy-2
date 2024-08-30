// Time Complexity: O(n)
// Space Complexity: O(1)

import java.util.HashMap;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxFreq = 0;

        for (int i = 0; i < tasks.length; i++) {
            map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(tasks[i]));
        }

        int maxCount = 0;
        for (char task : map.keySet()) {
            if (maxFreq == map.get(task))
                maxCount++;
        }

        int partitions = (maxFreq - 1);
        int availableSlots = partitions * (n - (maxCount - 1));
        int pendingSlots = tasks.length - (maxFreq * maxCount);
        int idleSlots = Math.max(0, availableSlots - pendingSlots);

        return tasks.length + idleSlots;

    }
}