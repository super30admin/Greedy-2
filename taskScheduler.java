// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.*;

class Main {

    // greedy approch by schedule critical task first with max freq
    public static int leastInterval(char[] tasks, int n) {
        // null case
        if (tasks == null || tasks.length == 0)
            return 0;
        if (n == 0)
            return tasks.length;
        HashMap<Character, Integer> map = new HashMap<>();
        int t = tasks.length;
        // count each task and its freq
        int maxFreq = 0;
        int maxCount = 0;
        for (char task : tasks) {
            if (!map.containsKey(task)) {
                map.put(task, 0);
            }
            // current Freq of any tasks
            int curr = map.get(task);
            map.put(task, curr + 1);
            maxFreq = Math.max(maxFreq, map.get(task));
        }
        // second pass
        // count maxCount with maxFreq tasks
        for (char key : map.keySet()) {
            if (map.get(key) == maxFreq) {
                maxCount++;
            }
        }
        // partition
        int partition = maxFreq - 1;
        // available time betwwen critical tasks is product
        // of partition into effective k
        int available = partition * (n - (maxCount - 1));
        // remaining tasks
        int rem = t - (maxCount * maxFreq);
        // idle time
        int idle = Math.max(0, available - rem);
        return t + idle;
    }

    public static void main(String[] args) {
        char[] tasks = new char[] { 'A', 'A', 'A', 'B', 'B', 'B' };
        int n = 2;
        System.out.println(leastInterval(tasks, n));
    }
}