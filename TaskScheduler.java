import java.util.HashMap;
import java.util.Map;

//TC: O(n), SC: O(n)
public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        final Map<Character, Integer> frequency = new HashMap<>();
        int maxFreq = 0, maxFreqTasks = 0;

        for (char task: tasks) {
            frequency.put(task, frequency.getOrDefault(task, 0) + 1);
            maxFreq = Math.max(maxFreq, frequency.get(task));
        }

        for (char key: frequency.keySet()) if (frequency.get(key) == maxFreq) maxFreqTasks++;

        int partition = maxFreq - 1;
        int available = partition * (n - (maxFreqTasks - 1));
        int pending = tasks.length - maxFreq * maxFreqTasks;
        int idle = Math.max(0, available - pending);

        return tasks.length + idle;
    }
}
