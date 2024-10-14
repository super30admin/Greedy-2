// Time Complexity : O(n) as we iterate over tasks array
// Space Complexity : O(1) as we have character hashmap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes. Formuala for idle slots was incorrect. Did  not consider when empty slots was negative.

/*
Approach: Use hashmap to store the character and frequency of the occurance of that character. Then calculate maxFrequency i.e. the char that occurs max times and maxCount = no.of char having maxFrequency. Then simply use formulas to calculate partitions, empty slots, pending tasks, idle slots. Then simply return tasks.length + idle slots
 */
class Solution {
    public int leastInterval(char[] tasks, int n) {

        HashMap<Character, Integer> map = new HashMap<>();
        int maxFrequency = 0;
        int maxCount = 0;

        for(int i =0; i <tasks.length; i++){
            map.put(tasks[i], map.getOrDefault(tasks[i], 0)+ 1);
            maxFrequency = Math.max(maxFrequency, map.get(tasks[i]));
        }

        for(char key: map.keySet()){
            if(map.get(key) == maxFrequency){
                maxCount++;
            }
        }

        int partitions = maxFrequency - 1;
        int emptySlots = partitions * (n - (maxCount -1));
        int pendingTasks = tasks.length - (maxFrequency * maxCount);
        int idleSlots = Math.max(0, (emptySlots - pendingTasks));

        return tasks.length + idleSlots;
    }
}