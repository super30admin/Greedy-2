// Time complexity: O(N+N)
// Space complexity: O(1)
import java.util.*;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) return 0;
        if(n == 0) return tasks.length;
        int maxFreq = 0, maxCount = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i=0; i< tasks.length; i++) {
            char c = tasks[i];
            map.put(c, map.getOrDefault(c, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(c));
        }

        for (int i=0; i < tasks.length; i++) {
            char c = tasks[i];
            if (map.get(c) == maxFreq) {
                maxCount++;
            }
        }

        int partitions = maxFreq - 1;
        int empty = partitions * (n - (maxCount -1));
        int pendingTasks = tasks.length - (maxFreq * maxCount);
        int idle = Math.max(0, empty - pendingTasks);

        return tasks.length + idle;

    }
}
