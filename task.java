// Time Complexity : 0(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        int len = tasks.length;
        int maxFreq = 0;
        int maxCount = 0;
        for (int i = 0; i < len; i++) {
            if (!map.containsKey(tasks[i])) {
                map.put(tasks[i], 0);
            }
            map.put(tasks[i], map.get(tasks[i]) + 1);
            maxFreq = Math.max(maxFreq, map.get(tasks[i]));
        }
        for (char key : map.keySet()) {
            if (map.get(key) == maxFreq) {
                maxCount++; // getting how many times we are getting a character with max freq
            }
        }
        int partitions = maxFreq - 1;
        int empty = partitions * (n - (maxCount - 1));
        int pending = len - maxFreq * maxCount;
        int idle = Math.max(0,empty - pending);
        int total = len + idle;

        return total;
    }
}