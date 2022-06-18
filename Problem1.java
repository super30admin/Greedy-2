import java.util.HashMap;
import java.util.Map;

public class Problem1 {
    // TC : O(n)
    // SC : O(1)
    public int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) return 0;
        if (n == 0) return tasks.length;

        Map<Character, Integer> map = new HashMap<>();

        int maxFreq = 0, maxCount = 0;
        for (int i = 0; i < tasks.length; i++) {
            char c = tasks[i];
            map.put(c, map.getOrDefault(c, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(c));
        }

        for (char c : map.keySet()) {
            if (maxFreq == map.get(c)) {
                maxCount++;
            }
        }

        int partitions = maxFreq - 1;
        int empty = partitions * (n - (maxCount - 1));
        int pendingTask = tasks.length - (maxFreq * maxCount);
        int idle = Math.max(0, empty - pendingTask);

        return tasks.length + idle;
    }
}
