// Time Complexity : O(n)
// Space Complexity : O(1) -> We use a HashMap that can contain a fixed number of characters
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// 1: We maintain a HashMap to determine the maxFrequency present for a task and also calculate the number of tasks with this maxFrequency
// 2: We use the greedy approach to determine how many empty slots are present after scheduling each task
// 3: We return the number of tasks + number of empty slots to determine the number of CPU intervals required
class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxFreq=0, maxCount = 0;

        // inserting into HashMap
        for(char task: tasks){
            map.put(task, map.getOrDefault(task,0) + 1);
            maxFreq = Math.max(maxFreq, map.get(task));
        }
        // get maxCount from the HashMap frequencies
        for(char key : map.keySet()){
            if(map.get(key) == maxFreq){
                maxCount++;
            }
        }

        int partitions = maxFreq - 1;
        int available = partitions * (n-(maxCount -1));
        int pending = tasks.length - (maxFreq * maxCount);
        int empty = Math.max(0, available - pending);
        return tasks.length + empty;
    }
}