// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class TaskScheduler {
    class Solution {
        public int leastInterval(char[] tasks, int n) {
            Map<Character, Integer> map = new HashMap<>();
            int maxFreq = 0;
            for(char task : tasks){
                map.put(task, map.getOrDefault(task, 0) + 1);
                maxFreq = Math.max(maxFreq, map.get(task));
            }

            int tasksWithMaxFreq = 0;
            for(char task : map.keySet()){
                if(map.get(task) == maxFreq)
                    tasksWithMaxFreq++;
            }

            int size = tasks.length;
            int total = ((n + 1) * (maxFreq - 1)) + tasksWithMaxFreq;
            return Math.max(total, size);
        }
    }
}
