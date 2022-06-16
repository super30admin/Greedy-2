// Time Complexity: O(n) where n is the number of tasks.
// Space Complexity: O(1).
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        if(tasks == null || tasks.length == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int maxFreq = 0;        // Same tasks
        int maxCount = 0;       // Same freq of different tasks.
        for(int i = 0; i < tasks.length; i++) {
            char c = tasks[i];
            map.put(c, map.getOrDefault(c, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(c));
        }
        // Go through keys in the HashMap to get maxCount.
        for(char c: map.keySet()) {
            if(maxFreq == map.get(c)) {
                maxCount++;
            }
        }
        int partitions = maxFreq - 1;
        int empty = partitions * (n - (maxCount - 1));
        int pendingTasks = tasks.length - (maxFreq * maxCount);
        int idle = Math.max(0, empty - pendingTasks);
        return tasks.length + idle;
    }
}