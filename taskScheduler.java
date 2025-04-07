// Problem2 Queue Reconstruction by Height (https://leetcode.com/problems/queue-reconstruction-by-height/)

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, take the frequency of characters and count the number of characters with max frequency and have partitions as maxfreq-1 and available
 * slots as partitions * (n - (maxCount - 1)) and pending tasks as tasks.length - (maxFreq * maxCount) and idle as Math.max(0, availableSlots - pendingTasks).
 * Finally return tasks.length + idleTasks.
 */
class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxFreq = 0;
        for(char ch: tasks){
            map.put(ch, map.getOrDefault(ch, 0)+1);
            maxFreq = Math.max(maxFreq, map.get(ch));
        }
        int maxCount = 0;
        for(char ch:map.keySet()){
            if(map.get(ch) == maxFreq){
                maxCount++;
            }
        }
        int partitions = maxFreq - 1;
        int availableSlots = partitions * (n - (maxCount - 1)); // since one is already used
        int pendingTasks = tasks.length - (maxFreq * maxCount);
        int idleTasks = Math.max(0, availableSlots - pendingTasks);
        return tasks.length + idleTasks;
    }
}