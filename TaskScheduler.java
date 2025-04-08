/*
 * TC: O(n)
 * SC: O(1)
 */
public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        int maxFreq = 0;
        int maxFreqTasks = 0;
        // calculate the max frequency
        // and the number of tasks with the max frequency
        for(char t: tasks) {
            freq[t - 'A']++;
            int f = freq[t - 'A'];
            if(maxFreq < f) {
                maxFreq = f;
                maxFreqTasks = 1;
            }
            else if(maxFreq == f) {
                maxFreqTasks++;
            }
        }
        // [A A A B B B C] n = 2

        // [A B A B A B] (6)
        int totalSlotsForMaxFreqTasks = maxFreq * maxFreqTasks;
        // [A B C A B A B] (1)
        int totalSlotsForRemainingTasks = tasks.length - totalSlotsForMaxFreqTasks;
        // [A B . A B . A B] (2)
        int totalSlotsForNIntervals = maxFreqTasks <= n ? (maxFreq - 1) * (n - maxFreqTasks + 1) : 0;
        // [A B C A B . A B] => 6 + max(1, 2) = 8
        return totalSlotsForMaxFreqTasks + Math.max(totalSlotsForRemainingTasks, totalSlotsForNIntervals);
    }
}
