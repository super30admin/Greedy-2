// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// We find the task frequency of each character and the max frequency of a task
// We find the number of tasks with max frequency since its the only bottle neck we need to solve
// Once we schedule the max freq task, we find the number of idle slots remaining
//  scheduling more pending slots than available idle slots will make idle slots 0
// return number of tasks + idle slots

class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap();
        int maxFreq = 0;
        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(c));
        }
        int cntMax = 0;
        for (char c : map.keySet())
            if (map.get(c) == maxFreq)
                cntMax++;

        int partitions = maxFreq - 1;
        int available = partitions * (n - (cntMax - 1));
        int pending = tasks.length - (cntMax * maxFreq);
        int idle = Math.max(0, available - pending);
        return tasks.length + idle;
    }
}