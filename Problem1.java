//Time = O(n log n)
//Space = O(1)

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] taskCount = new int[26]; // array to store count of each task
        for (char task : tasks) {
            taskCount[task - 'A']++;
        }
        Arrays.sort(taskCount); // sort tasks in ascending order of count
        
        int maxCount = taskCount[25]; // max count of a task
        int idleTime = (maxCount - 1) * n; // calculate idle time
        for (int i = 24; i >= 0 && taskCount[i] > 0; i--) {
            idleTime -= Math.min(maxCount - 1, taskCount[i]); // subtract idle time for each task
        }
        return tasks.length + Math.max(0, idleTime); // return minimum time required
    }
}
