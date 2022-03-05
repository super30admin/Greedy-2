import java.util.*;
// Time Complexity : O(nlogn) (sorting) + O(n*n) (traverse and arrange) -> O(n^2)
// Space Complexity : O(1) as constant 26 alphabets
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        // null
        if (tasks == null || tasks.length == 0)
            return 0;
        // if no cooldown time.
        if (n == 0)
            return tasks.length;
        int maxFreq = 0, maxCount = 0;
        Map<Character, Integer> map = new HashMap();
        for (char task : tasks) {
            int cnt = map.getOrDefault(task, 0) + 1;
            maxFreq = Math.max(maxFreq, cnt);
            map.put(task, cnt);
        }
        for (char c : map.keySet()) {
            if (maxFreq == map.get(c)) {
                maxCount++;
            }
        }
        int partition = maxFreq - 1;
        int available = partition * (n - (maxCount - 1)); // one is already scheduled
        int pending = tasks.length - (maxFreq * maxCount);
        int idle = Math.max(0, available - pending);
        return tasks.length + idle;
    }
}
