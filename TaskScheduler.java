import java.util.HashMap;

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1) - since all tasks are alphabets and are used in hashmap, at most 26.
 *  Because it doesn't grow with the input size — even if the input tasks array is huge, the map size is capped at 26.
 * Did this code successfully run on Leetcode: Yes
 * Any problem you faced while coding this: None

 * Approach:
 * 1. Think of placing the most frequent tasks first, creating maxFreq - 1 partitions between them.
 * 2. Each partition can ideally hold up to n tasks, but if multiple tasks have the same max frequency, some slots are already occupied.
 * So we calculate:
 * empty = partitions * (n - (maxCount - 1))
 * 3. Subtract the space already filled by other tasks to compute pending tasks and remaining idle slots.
 */

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxFreq = 0;
        int maxCount = 0;
        for (char task: tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(task));
        }

        for (char key: map.keySet()) {
            if(map.get(key) == maxFreq) {
                maxCount++;
            }
        }

        int partitions = maxFreq - 1;
        int empty = partitions * (n - (maxCount - 1));
        int pending = tasks.length - (maxFreq * maxCount);
        int idle = Math.max(0, empty - pending);
        return tasks.length + idle;
    }
    public static void main(String[] args) {
        // Your code here
    }
}