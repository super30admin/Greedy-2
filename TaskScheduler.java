import java.util.HashMap;
import java.util.Map;
class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freqMap = new HashMap<>();
        int maxFreq = 0, maxCount = 0;
        for(int i = 0; i < tasks.length; i++)
        {
            freqMap.put(tasks[i], freqMap.getOrDefault(tasks[i],0) + 1);
            maxFreq = Math.max(maxFreq, freqMap.get(tasks[i]));
        }
        
        for(char key : freqMap.keySet())
        {
            if(maxFreq == freqMap.get(key))
            {
                maxCount++;
            }
        }

        int partitions = maxFreq - 1;
        int avialableSlots = partitions * (n - (maxCount - 1));
        int pendingTasks = tasks.length - (maxFreq * maxCount);
        int emptySlots = Math.max(0, avialableSlots - pendingTasks);

        return tasks.length + emptySlots;
    }
}