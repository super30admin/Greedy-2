// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

/*
Approach
We are using the greedy approach
first we need to know how many task are repeated how many time so we create a freq map
while building it we keep track of the max freq as we will have to schedle them first
then find out how many task have the max freq 
we then use math to calculte everything

*/

class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxFreq = 0;
        int noMaxFreqTask = 0;
        for (int i = 0; i < tasks.length; i++) {
            map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);
            maxFreq = Math.max(map.get(tasks[i]), maxFreq);
        }
        for (char task : map.keySet()) {
            if (map.get(task) == maxFreq) {
                noMaxFreqTask++;
            }
        }
        int noOfPartitions = maxFreq - 1;
        int availableSlots = noOfPartitions * (n - (noMaxFreqTask - 1));
        int noOfPendingTasks = tasks.length - (maxFreq * noMaxFreqTask);
        int idle = Math.max(0, availableSlots - noOfPendingTasks);
        return tasks.length + idle;
    }
}