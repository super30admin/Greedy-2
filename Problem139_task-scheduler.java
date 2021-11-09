// Time Complexity: O(n)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int leastInterval(char[] tasks, int n) {
        if(tasks == null || tasks.length == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int maxFreq = 0;
        for(int i = 0; i < tasks.length; i++) {
            map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(tasks[i]));
        }
        int maxCount = 0;
        for(char task: map.keySet()) {
            if(maxFreq == map.get(task)) {
                maxCount++;
            }
        }
        int partitions = maxFreq - 1;
        int empty = partitions * (n - (maxCount - 1));
        int pendingTasks = tasks.length - (maxCount * maxFreq);
        int idle = Math.max(0, empty - pendingTasks);
        
        return tasks.length + idle;
    }
}