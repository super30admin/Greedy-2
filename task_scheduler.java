// Time Complexity :O(n) where n is length of tasks array
// Space Complexity :constant
// Did this code successfully run on Leetcode :yes


class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxFreq = 0;
        // making hashmap for calculating the maxfreq and maxcount
        for (char task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(task));
        }

        int maxCount = 0;
        for (Character c : map.keySet()) {
            if (map.get(c) == maxFreq) {
                maxCount++;
            }
        }
        int partition = maxFreq - 1;

        int available = partition * (n - (maxCount - 1));
        int pending = tasks.length - (maxFreq * maxCount);

        int idle = Math.max(0, (available - pending));
        return (tasks.length + idle);
    }
}