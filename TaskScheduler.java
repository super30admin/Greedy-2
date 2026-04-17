// Time Complexity : O(T + k), where T = number of total tasks and k = number of unique tasks
// Space Complexity : O(C), number of task counts for hashmap = O(26) = O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
We first determine number of most frequently occuring tasks along with their count. Now we determine number
of partitions required and calculate the idle slots required between them. If other tasks can fill these slots
we do, if not, we simply add the idle tasks to total task length.
 */
class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        int maxCount = 0, maxFreq = 0;

        for(char task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(task));
        }

        for(char c : map.keySet()) {
            if(map.get(c) == maxFreq) {
                maxCount++;
            }
        }

        int partitions = maxFreq - 1;
        int available = partitions * (n - (maxCount - 1));
        int pending = tasks.length - maxCount * maxFreq;
        int idle = Math.max(0, available - pending);

        return tasks.length + idle;
    }
}