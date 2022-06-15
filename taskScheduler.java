/*
Problem: https://leetcode.com/problems/task-scheduler/
TC: O(n)
SC: O(1)
*/
class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) {
            return 0;
        }
        
        HashMap<Character, Integer> taskFreqMap = new HashMap<>();
        int maxFreq = 0;
        int maxFreqTaskCount = 0;
        
        for (int i = 0; i < tasks.length; ++i) {
            if (!taskFreqMap.containsKey(tasks[i])) {
                taskFreqMap.put(tasks[i], 0);
            }
            taskFreqMap.put(tasks[i], taskFreqMap.get(tasks[i]) + 1);
            maxFreq = Math.max(maxFreq, taskFreqMap.get(tasks[i]));
        }
        
        for (Character task : taskFreqMap.keySet()) {
            if (taskFreqMap.get(task) == maxFreq) {
                ++maxFreqTaskCount;
            }
        }
        
        // intervals after placing one task of max freq with n spaces in each interval
        int partitions = maxFreq - 1;
        // -1 because we already placed one element of max freq previously to calculate partitions
        int empty = partitions * (n - (maxFreqTaskCount - 1));
        int pendingTasks = tasks.length - (maxFreq * maxFreqTaskCount);
        int idleSlots = Math.max(0, empty - pendingTasks);
        
        return tasks.length + idleSlots;
    }
}