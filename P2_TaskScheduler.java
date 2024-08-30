//TC: O(n)
//SC: O(n)

class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxFreq = 0;
        int maxCount = 0;
        for(int i=0 ; i<tasks.length ; i++) {
            map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(tasks[i]));
        }
        for(char task : map.keySet()) {
            if(map.get(task) == maxFreq) {
                maxCount += 1;
            }
        }
        int partitions = maxFreq - 1;
        int availableSlots = partitions * (n - (maxCount - 1));
        int pendingTasks = tasks.length - (maxFreq * maxCount);
        int idleSlots = Math.max(0, availableSlots - pendingTasks);

        return tasks.length + idleSlots;
    }
}