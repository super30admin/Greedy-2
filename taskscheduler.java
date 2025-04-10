// TC: O(n)
// SC: O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    // TC = O(n), SC = O(n)
    public int leastInterval(char[] tasks, int n) {
        if(tasks == null || tasks.length == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>(); // records the task & its freq
        int maxFreq = 0, maxCount = 0;
        for(int i = 0; i < tasks.length; i++) {
            char c = tasks[i];
            map.put(c, map.getOrDefault(c, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(c));
        }
        for(char key : map.keySet()) {
            if(map.get(key) == maxFreq) maxCount++;
        }
        // These are the terms formulas
        int partitions = maxFreq - 1;
        int empty = partitions * (n - (maxCount - 1));
        int pending = tasks.length - (maxFreq * maxCount);
        int idle = Math.max(0, empty - pending);
        return tasks.length + idle;
    }
}