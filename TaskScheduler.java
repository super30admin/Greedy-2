// Time Complexity : O(N)
// Space Complexity : O(1) , atmost 26 character in HashMap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA


// Your code here along with comments explaining your approach

// Store the Task letters and its frequency in a HashMap
// Find the Max Frequency and Count of Max freq
// Find the partitions, empty places ,pending places and idle places as below
// Partitions = MaxFreq - 1
// Empty = partitions * (n - MaxCount + 1)
// Pending = task.length - (MaxCount * MaxFreq)
// Idle = Math.max(0, Empty - Pending)
// Return answer as task.length + idle

class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        if(tasks == null || tasks.length == 0) return 0;
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        int maxFreq = 0, maxCount = 0;
        
        for(char c: tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(c)); 
        }
        
        for(char c: map.keySet()) {
            if(map.get(c) == maxFreq) {
                maxCount++;
            }
        }
        
        int partitions = maxFreq - 1;
        int empty = partitions * (n - maxCount + 1);
        int pending = tasks.length - (maxFreq * maxCount);
        int idle = Math.max(0 , empty - pending);
        int ans = tasks.length + idle;
        
        return ans;
        
    }
}