import java.util.HashMap;
import java.util.Map;
/*
Tasks Scheduler
approach: by taking different scenarios, we have to arrange the task which is most repeated then calculate
partitions, available slots, pending tasks, empty slots. time will always be the number of tasks + empty slots
time: O(n)
space: O(1)
 */
public class Problem1 {
    public int leastInterval(char[] tasks, int n) {

        int min = 0, maxFreq = 0, tasksWithMaxFreq = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        // get frequency map
        for (int i=0;i<tasks.length;i++) {
            map.put(tasks[i], map.getOrDefault(tasks[i], 0)+1);
            maxFreq = Math.max(map.get(tasks[i]), maxFreq);
        }

        //get how many tasks have max freq
        for (Character key: map.keySet()) {
            if (maxFreq==map.get(key)) tasksWithMaxFreq++;
        }

        int parts = maxFreq-1;
        int available = parts*(n-(tasksWithMaxFreq-1));
        int pending = tasks.length-(maxFreq*tasksWithMaxFreq);
        int empty = Math.max(available-pending,0);

        return empty+tasks.length;
    }
}
