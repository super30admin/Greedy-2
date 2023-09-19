// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/*
 * Count the frequency for each task, and keep track of max frequency and how many tasks are there with max freq.
 * using mathematical formula, given in the code, compute the time. 
 */

import java.util.HashMap;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> taskFrequency = new HashMap<>();
        int maxFrequency = 0;
        
        for (char task : tasks) {
            int frequency = taskFrequency.getOrDefault(task, 0) + 1;
            taskFrequency.put(task, frequency);
            maxFrequency = Math.max(maxFrequency, frequency);
        }

        int countOfMaxFrequencyTasks = 0;
        for (char task : taskFrequency.keySet()) {
            if (taskFrequency.get(task) == maxFrequency) {
                countOfMaxFrequencyTasks++;
            }
        }

        int partitions = maxFrequency - 1;
        int availableSlots = (n - (countOfMaxFrequencyTasks - 1)) * partitions;
        int pendingTasks = tasks.length - (countOfMaxFrequencyTasks * maxFrequency);
        
        int idleTime = Math.max(0, availableSlots - pendingTasks);
        
        return tasks.length + idleTime;
    }
}
