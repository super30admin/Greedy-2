// Time Complexity: O(n) where n is the number of tasks
// Space Complexity: O(1) since the map will have at most 26 characters

import java.util.HashMap;
import java.util.Map;

class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        int maxFreq = 0;
        int maxFreqTasks = 0;

        for(int i = 0; i < tasks.length; i++){
            map.put(tasks[i], map.getOrDefault(tasks[i], 0)+1);
            maxFreq = Math.max(maxFreq, map.get(tasks[i]));
        }

        for(char task: map.keySet()){
            if(map.get(task) == maxFreq){
                maxFreqTasks++;
            }
        }

        int partitions = maxFreq - 1;
        int emptySlots = partitions*(n-(maxFreqTasks-1));
        int pendingTasks = tasks.length - (maxFreq*maxFreqTasks);
        int idles = Math.max(0, emptySlots-pendingTasks);

        return tasks.length + idles;
    }
}