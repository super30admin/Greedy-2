// Time Complexity :O(n) where n is length of tasks array
// Space Complexity :constant
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
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
        // no of partitions will be dependent on maxfreq
        int partition = maxFreq - 1;
        // the available slots will decrease if we have more tasks of maxfrequency
        int available = partition * (n - (maxCount - 1));
        // here we are calculating how many tasks are pending to be scheduled, after
        // tasks having maxCount are scheduled
        int pending = tasks.length - (maxFreq * maxCount);
        // now after scheduling all how many are idle that will add up in our result
        int idle = Math.max(0, (available - pending));
        return (tasks.length + idle);
    }
}