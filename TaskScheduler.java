// TC: O(n)
// SC: O(1)
class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();

        int maxFrequency = 0;
        for (char task : tasks) {
            if (!map.containsKey(task)) {
                map.put(task, 0);
            }
            map.put(task, map.get(task) + 1);
            maxFrequency = Math.max(maxFrequency, map.get(task));
        }

        int numMaxFreq = 0;
        for (char key : map.keySet()) {
            if (map.get(key) == maxFrequency) {
                numMaxFreq++;
            }
        }

        int partitions = maxFrequency - 1;
        int available = partitions * (n - (numMaxFreq - 1));
        int remaining = tasks.length - (numMaxFreq * maxFrequency);
        int ideal = Math.max(0, available - remaining);

        return tasks.length + ideal;
    }
}