// Time Complexity : O(n)
// Space Complexity : O(1)

/*
 * store the count of each element in hashmap. get the max count and
 * we arrange all the elements with minimum idle time. return the
 * number of task plus the idle time if any.
 */

class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxFreq = 0; int maxCount = 0;
        for(char task: tasks){
            map.put(task, map.getOrDefault(task, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(task));
        }
        for(char key: map.keySet()){
            if(map.get(key) == maxFreq) maxCount++;
        }

        int partition = maxFreq - 1;
        int availableSlot = partition * (n - (maxCount - 1));
        int pendingTask = tasks.length - (maxCount * maxFreq);
        int idle = Math.max(0, availableSlot - pendingTask);
        return tasks.length + idle;
    }
}