// TC : O(n)
// SC : O(1)

class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0)
            return 0;

        HashMap<Character, Integer> map = new HashMap<>();
        int maxFreq = 0, maxCount = 0;
        for (int i = 0; i < tasks.length; i++) {
            char task = tasks[i];
            map.put(task, map.getOrDefault(task, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(task));
        }

        for (char key : map.keySet()) {
            if (map.get(key) == maxFreq) {
                maxCount++;
            }

        }
        int partitions = maxFreq - 1;
        int empty = partitions * (n - (maxCount - 1));
        int incompleteTasks = tasks.length - (maxFreq * maxCount);
        int idle = Math.max(empty - incompleteTasks, 0);
        return tasks.length + idle;

    }
}