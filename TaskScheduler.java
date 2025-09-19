/**
Think of scheduling the most frequent task(s) first.

If the max frequency is maxFreq, then there are maxFreq - 1 "full cycles" of spacing between them.
Each cycle is of length (n + 1) (the task itself + n cooldown slots).

So the minimum slots needed:

(minTime) = (maxFreq - 1) * (n + 1) + countMax


Explanation:

(maxFreq - 1) cycles

Each cycle length = (n + 1)

In the last cycle, we only need to place the countMax tasks.

Step 3: Compare with total tasks

Sometimes, there are so many tasks that idle time disappears naturally.

So final answer is:

Math.max(tasks.length, (maxFreq - 1) * (n + 1) + countMax)
 */
class Solution {
    // Tasks: [A,A,A,B,B,B,C,C], n = 2. o/p 8
    // Tasks: [A,A,A,A,B,B,B,C,C]; n = 2. o/p 10
    // Tasks: [A,A,B,B,C,C], n = 2. o/p 6
    public int leastInterval(char[] tasks, int n) {
        if (tasks == null|| tasks.length == 0) {
            return 0;
        }

        int[] freqMap = new int[26];
        int maxFreq = 0;
        int maxCount = 0;

        for (char c : tasks) {
            freqMap[c - 'A']++;
            maxFreq = Math.max(maxFreq, freqMap[c - 'A']);
        }

        
        for (int i = 0; i < 26; ++i) {
            if (freqMap[i] == maxFreq) {
                maxCount++;
            }
        }
        // Compare with total tasks
        // Sometimes, there are so many tasks that idle time disappears naturally.
        // So final answer is:
        // Math.max(tasks.length, (maxFreq - 1) * (n + 1) + countMax)
        return Math.max(tasks.length, (maxFreq - 1) * (n + 1) + maxCount);
    }
}