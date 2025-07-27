// Time Complexity- O(n)
// Space complexity -O(1)
// solved on leetcode - yes
// faced any issues - No
class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0, maxNum = 0;

        // Count frequencies and find max frequency
        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            max = Math.max(max, map.get(c));
        }

        // Count how many tasks have the max frequency
        for (int freq : map.values()) {
            if (freq == max) {
                maxNum++;
            }
        }

        int partitions = max - 1;
        int availableSlots = partitions * Math.max(0, n - (maxNum - 1));
        int pendingTasks = tasks.length - (max * maxNum);
        int idleSlots = Math.max(0, availableSlots - pendingTasks);

        return tasks.length + idleSlots;
    }
}
