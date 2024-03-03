import java.util.HashMap;
import java.util.Map;

public class TaskScheduler {
    // TC: O(N) where N is length of tasks array
    // SC: O(N) where N is length of tasks array
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freq = new HashMap<>();
        int maxFreq = 0, tasksWithMaxFreq = 0;
        for (char ch : tasks) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
            if (freq.get(ch) > maxFreq) {
                maxFreq = freq.get(ch);
                tasksWithMaxFreq = 1;
            } else if (freq.get(ch) == maxFreq) {
                tasksWithMaxFreq++;
            }
        }
        int partitions = maxFreq - 1;
        int idleSlots = partitions * (n - tasksWithMaxFreq + 1);
        int remaining = tasks.length - (maxFreq * tasksWithMaxFreq);
        int idle = Math.max(0, idleSlots - remaining);
        return idle + tasks.length;
    }
}
