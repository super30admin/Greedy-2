import java.util.HashMap;

// Time Complexity : O(n) where n = length of tasks array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//621. Task Scheduler (Medium) - https://leetcode.com/problems/task-scheduler/
// Time Complexity : O(n) where n = length of tasks array
// Space Complexity : O(1)
class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxFreq = 0, maxCount = 0;
        
        for (char task : tasks) { // put the tasks against its count in a hash map
            if (!map.containsKey(task)) {
                map.put(task, 0);
            }
            
            int count = map.get(task);
            count++;
            maxFreq = Math.max(count, maxFreq); // get the maximum frequency
            map.put(task, count);
        }
        
        for (Character task : map.keySet()) { // get the count of tasks having maximum frequency
            if (map.get(task) == maxFreq) {
                maxCount++;
            }
        }
        
        int partitions = maxFreq - 1;
        int available = partitions * (n - (maxCount-1));
        int pending = tasks.length - (maxFreq * maxCount);
        int empty = Math.max(0, available-pending);
        
        return tasks.length + empty;
    }
}