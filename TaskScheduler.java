// Time Complexity :O(n) as we iterate over the tasks array once
// Space Complexity :O(1) HashMap will have at the most 26 keys
// Did this code successfully run on Leetcode :yes
import java.util.HashMap;
public class TaskScheduler {
    private HashMap<Character, Integer> frequencyMap;
    public int leastInterval(char[] tasks, int n) {
        if(n == 0){
            return tasks.length;
        }
        this.frequencyMap = new HashMap<>();

        //first create the frequencyMap
        int maxFrequency = 0;
        for(Character c : tasks){
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0)+1);
            maxFrequency = Math.max(maxFrequency, frequencyMap.get(c));
        }

        int maxFrequencyCount = 0;
        for(Character c: frequencyMap.keySet()){
            if(frequencyMap.get(c) == maxFrequency){
                maxFrequencyCount++;
            }
        }

        int numberOfPartitions = maxFrequency -1;
        int numberOfAvailableSlots = numberOfPartitions * (n - (maxFrequencyCount-1));
        int numberOfPendingTasks = tasks.length - maxFrequency*maxFrequencyCount;
        int numberOfIdleSlots = Math.max (0, numberOfAvailableSlots - numberOfPendingTasks);

        return numberOfIdleSlots + tasks.length;
    }
}
