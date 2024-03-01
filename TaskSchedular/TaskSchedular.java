/* Time Complexity : O(m)
 *  m - length of array - tasks */
/* Space Complexity : O(26) ~ O(1) 
 * size of the HashMap */
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//Greedy

class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        int len = tasks.length;
        int maxFreq = 0;
        int tasksWithMaxFreq = 0;
        for(char c: tasks){
            map.put(c, map.getOrDefault(c, 0) + 1);
            if(map.get(c) > maxFreq){
                maxFreq = map.get(c);
                tasksWithMaxFreq = 0;
            }
            if(map.get(c) == maxFreq){
                tasksWithMaxFreq++;
            }
        }

        int partitions = maxFreq - 1;
        int availableSlots = partitions * (n - (tasksWithMaxFreq - 1));
        int pendingTasks = len - (maxFreq * tasksWithMaxFreq);
        int idleSlots = Math.max(0, availableSlots - pendingTasks);

        return len + idleSlots;
    }
}