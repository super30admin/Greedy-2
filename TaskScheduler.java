// Time Complexity : O(n)
// Space Complexity : O(1), constant space map of 26 tasks
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class TaskScheduler {
    class Solution {
        public int leastInterval(char[] tasks, int n) {
            Map<Character, Integer> frequencyMap = new HashMap<>();
            int maxFreq = 0;
            //calculate maxFreq
            for(char task : tasks) {
                frequencyMap.put(task, frequencyMap.getOrDefault(task,0) + 1);
                maxFreq = Math.max(maxFreq, frequencyMap.get(task));
            }

            //calculate numTasksWithMaxFreq
            int numTasksWithMaxFreq = 0;
            for(Character key : frequencyMap.keySet()) {
                if(frequencyMap.get(key) == maxFreq)
                    numTasksWithMaxFreq+=1;
            }

            //evaluate the expressions
            int numPartitions = maxFreq - 1;
            int numAvailableSlots = numPartitions * (n - ( numTasksWithMaxFreq - 1));
            int numPendingTimeSlots = tasks.length - (maxFreq * numTasksWithMaxFreq);
            int numIdleSlots = Math.max(0, numAvailableSlots - numPendingTimeSlots);

            return tasks.length + numIdleSlots;
        }
    }
}
