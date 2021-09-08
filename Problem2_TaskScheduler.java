// Time Complexity : o(n)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int leastInterval(char[] tasks, int n) {
        
         if(tasks == null || tasks.length == 0) {
            return 0;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        int maxFreq = 0;
        int maxCount = 0;
        for(Character task : tasks) {
            int count = map.getOrDefault(task,0);
            count++;
            maxFreq = Math.max(maxFreq, count);
            map.put(task,count);
        }

        for(char c : map.keySet()) {
            if(map.get(c) == maxFreq) {
                maxCount++;
            }
        }
        int partitions = maxFreq - 1;
        int availableSlots = partitions * (n - (maxCount - 1));
        int pendingTasks = tasks.length - maxFreq * maxCount;
        int idleTime = Math.max(0,availableSlots - pendingTasks);

        return idleTime + tasks.length;
    }
}