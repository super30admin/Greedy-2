// TC: O(m)
// SC: O(1) // map and heap only contains 26 characters at most

// Approach: Schedule tasks by cycle and always schedule the one with the most
// frequency as it prevents bottleneck. After each cycle if there are tasks in heap
// add n + 1 else only the last executed tasks

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        Queue<Integer> heap = new PriorityQueue<Integer>((a, b) -> b - a);
        heap.addAll(map.values());
        int res = 0;

        while (!heap.isEmpty()) {
            List<Integer> executedTasks = new ArrayList<>();
            // if n is the cooldown; you can schedule n + 1 in 1 cycle
            for (int i = 0; i < n + 1; i++) {
                if (heap.isEmpty()) {
                    break;
                }
                executedTasks.add(heap.poll());
            }

            for (int t : executedTasks) {
                if (t - 1 > 0) {
                    heap.add(t - 1);
                }
            }

            // all tasks are scheduled
            res += heap.isEmpty() ? executedTasks.size() : n + 1;
        }

        return res;
    }
}
