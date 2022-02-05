// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach

// We do this using Greedy approach
// We calculate max freq then the partitions
// we calculate empty spaces
// then the pending and then idle spaces

class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0)
            return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int maxFreq = 0, maxCount = 0;

        for (int i = 0; i < tasks.length; i++) {
            map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(tasks[i]));
        }

        for (Character task : map.keySet()) {
            if (map.get(task) == maxFreq)
                maxCount++;
        }

        int partitions = maxFreq - 1;
        int empty = partitions * (n - (maxCount - 1));
        int pending = tasks.length - maxFreq * maxCount;
        int idle = Math.max(0, empty - pending);
        return idle + tasks.length;
    }
}