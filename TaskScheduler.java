// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        int maxFreq = 0, maxCount = 0;
        
        for(char ch: tasks) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(ch));
        }
        
        for(char ch: map.keySet()) {
            if(maxFreq == map.get(ch)) {
                maxCount++;
            }
        }

        int partitions = maxFreq - 1;
        int emptySlots = partitions * (n - (maxCount - 1));
        
        if(emptySlots <= 0) return tasks.length;
        
        int pendingTasks = tasks.length - (maxFreq * maxCount);
        int idleSlots = Math.max(0, emptySlots - pendingTasks);
        
        return tasks.length + idleSlots;
    }
}