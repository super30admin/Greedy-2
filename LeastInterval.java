// Problem 621. Task Scheduler
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxFreq = 0;
        int cntOfMax = 0;
        for (char task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(task));
        }
        for (char key : map.keySet()) {
            if (map.get(key) == maxFreq) {
                cntOfMax++;
            }
        }
        int partitions = maxFreq - 1;
        int available = partitions * (n - (cntOfMax - 1));
        int pending = tasks.length - (cntOfMax * maxFreq);
        int idle = Math.max(0, available - pending);
        return tasks.length + idle;
    }
}
