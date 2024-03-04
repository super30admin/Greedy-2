// Time Complexity : O(N)

// Space Complexity : O(N)

// Did this code successfully run on Leetcode : YES

// Appoarch: Using Greedy, using hashmap find the maxFreq and calculate the idle slots.
// return totalTasks + idle slots.

// 621. Task Scheduler

import java.util.HashMap;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxFreq = 0;
        int totalTasks = tasks.length;
        int noOfTaskWithSameFreq = 0;
        for(char task : tasks){
            map.put(task,map.getOrDefault(task,0) + 1);
            maxFreq = Math.max(maxFreq,map.get(task));
        }
        for(char task : map.keySet()){
            if(map.get(task) == maxFreq){
                noOfTaskWithSameFreq += 1;
            }
        }
        int partitions = maxFreq - 1;
        int slots = partitions * (n-(noOfTaskWithSameFreq-1));
        int pending = totalTasks - noOfTaskWithSameFreq*maxFreq;
        int idle = Math.max(0,slots - pending);
        return totalTasks + idle;
    }
}