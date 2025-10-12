/**
 * Approach: Use a max-heap to schedule the most frequent tasks first while respecting cooldowns using a queue.
 * Solution: Pop tasks from the heap, execute them, and push them into a cooldown queue with the next valid time.
 * Repeat until both heap and queue are empty, tracking total time to execute all tasks.
 */
public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] freqMap = new int[26];

        for (char ch : tasks) {
            freqMap[ch - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < 26; i++) {
            if (freqMap[i] > 0) {
                maxHeap.offer(freqMap[i]);
            }
        }
        Deque<int[]> queue = new LinkedList<>(); // count, time
        int time = 0;

        while (!maxHeap.isEmpty() || !queue.isEmpty()) {
            time++;

            if (!maxHeap.isEmpty()) {
                int currentCount = maxHeap.poll() - 1;
                if (currentCount > 0) {
                    queue.add(new int[] {currentCount, time + n });
                }
            }
            if (!queue.isEmpty() && queue.peekFirst()[1] == time) {
                int[] elementEligibleForMaxHeap = queue.removeFirst();
                maxHeap.offer(elementEligibleForMaxHeap[0]);
            }
        }

        return time;

    }
}