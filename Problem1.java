/*
621. Task Scheduler
Ran on leetcode: Yes
TC: O(n) SC: O(1)  since there are only lower case characters
Find the frequency of criticial tasks, also find the no of different type of critical tasks, find the partions created by placing the critical tasks, find the number of slots availble to place the non critical tasks, after placing the non critical tasks find if there are any idle slots. 
*/
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int tasksLen = tasks.length;

        // Create a frequency map and find the max frequency - ie max number of times a task has been repeated
        int maxFreq = 0;
        Map<Character, Integer> freqMap = new HashMap<>();
        for(char task: tasks){
            freqMap.put(task, freqMap.getOrDefault(task, 0) + 1);
            maxFreq = Math.max(maxFreq, freqMap.get(task));
        }
        
        // Find the critical task, tasks which are repeated maxFreq number of times
        int criticalTasks = 0;
        for(char task: freqMap.keySet()){
            int freq = freqMap.get(task);
            if(freq == maxFreq){
                criticalTasks++;
            }
        }

        // If there is A__A__A, if there is max freq of 3 the available partion will be 2
        int partions = maxFreq - 1;

        // Number of available slots in each partions AB_AB_AB - n = 2, criticalTasks = 2, slotsInEachPartion = 1
        int slotsInEachPartion = n - (criticalTasks - 1);

        // Total available slots - AB_AB_AB - availableSlots = 2, since there are two partions
        int availableSlots = partions * slotsInEachPartion;

        // idle slots, see if remaining non critical tasks can fill the available slots
        int remainingNonCritialTasks = tasks.length - (criticalTasks * maxFreq);
        int idleSlots = Math.max(0, availableSlots - remainingNonCritialTasks); // if there are no idle slots availble return 0 else return the difference

        return tasks.length + idleSlots;
    }
}