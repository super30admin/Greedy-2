// Time Complexity : O(m) where m is the number of tasks
// Space Complexity : O(m)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/**
 * Calculating the frequency of all tasks to be scheduled. First scheduling all max frequency tasks since those will dictate how many empty slots are left/needed for the rest of tasks.
 */

class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freq = new HashMap<>();
        int maxFreq = 0;
        for (char task : tasks) {
            freq.put(task, freq.getOrDefault(task, 0) + 1);
            maxFreq = Math.max(maxFreq, freq.get(task));
        }

        int maxFreqTasks = 0;
        for (char task : freq.keySet()) {
            if (freq.get(task) == maxFreq)
                maxFreqTasks++;
        }

        // after scheduling the tasks with max frequency, we will have -1 partitions in between those tasks
        int partitions = maxFreq - 1;
        int availableSlots = partitions * (n - (maxFreqTasks - 1));
        int pending = tasks.length - (maxFreq * maxFreqTasks);
        // doing max since available-pending might return a negative number if we have extra pending tasks
        int idle = Math.max(0, availableSlots - pending);
        return tasks.length + idle;
    }
}