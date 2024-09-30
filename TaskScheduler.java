// Time Complexity : O(2n) ~ O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxFreq = 0;
        for(int i = 0; i < tasks.length; i++) {
                map.put(tasks[i], map.getOrDefault(tasks[i], 0)+1);
                maxFreq = Math.max(maxFreq, map.get(tasks[i]));
        }
        int maxFreqCount = 0;
        for(char c : map.keySet()) {
            if(map.get(c) == maxFreq) {
                maxFreqCount++;
            }
        }
        int partitions = maxFreq - 1;
        int availableSlots = partitions * (n - (maxFreqCount - 1));
        int pendingTasks = tasks.length - (maxFreq * maxFreqCount);
        int idleTime = Math.max(0, availableSlots - pendingTasks);
        return tasks.length + idleTime;
    }
}