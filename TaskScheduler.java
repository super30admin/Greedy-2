// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach: Calculate the frequency of each task using a HashMap. Find the maximum frequency and count the tasks with that frequency. Determine the number of partitions based on the maximum frequency. Calculate the available slots for tasks and the pending tasks. Return the total number of tasks plus the maximum of idle slots or zero, considering the intervals between tasks and the pending tasks.

import java.util.HashMap;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxFreq = 0;
        int maxCount = 0;
        for (char task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(task));
        }

        for (char task : map.keySet()) {
            if (map.get(task) == maxFreq)
                maxCount++;
        }

        int partitions = maxFreq - 1;
        int available = partitions * (n - (maxCount - 1));
        int pending = tasks.length - maxFreq * maxCount;
        int idle = Math.max(0, available - pending);

        return tasks.length + idle;
    }

    public static void main(String[] args) {
        TaskScheduler taskScheduler = new TaskScheduler();

        char[] tasks1 = { 'A', 'A', 'A', 'B', 'B', 'B' };
        int n1 = 2;
        System.out.println("Minimum intervals (tasks1): " + taskScheduler.leastInterval(tasks1, n1));

        char[] tasks2 = { 'A', 'A', 'A', 'B', 'B', 'B' };
        int n2 = 0;
        System.out.println("Minimum intervals (tasks2): " + taskScheduler.leastInterval(tasks2, n2));
    }
}
