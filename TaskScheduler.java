import java.util.HashMap;
import java.util.Map;

public class TaskScheduler {
    // TC : O(n) n - number of tasks
    // SC : O(1)
    public int leastInterval(char[] tasks, int n) {
        if(tasks == null || tasks.length == 0) return 0;

        Map<Character,Integer> map = new HashMap<>();
        int maxFreq = 0, maxCount = 0;

        // Calculate max frequency first
        for(char task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(task));
        }

        // Based on max frequency calculated above, get the max count value
        // max count represents how many tasks have max frequency
        for(char task : map.keySet()) {
            if(maxFreq == map.get(task)) maxCount++;
        }

        int partitions = maxFreq - 1;
        int empty = partitions * (n - (maxCount - 1));
        if(empty <= 0) return tasks.length;
        int pendingTasks = tasks.length - (maxFreq * maxCount);
        int idle = Math.max(0, empty - pendingTasks);

        return tasks.length + idle;

    }
}
