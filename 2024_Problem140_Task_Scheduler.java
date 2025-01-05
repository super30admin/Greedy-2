//621. Task Scheduler - https://leetcode.com/problems/task-scheduler/description/
//Time Complexity: O(n) ~ going through every task
//Space Complexity: O(1) ~ no extra space needed, calculating on the fly

//Greedy Solution
class Solution {
    public int leastInterval(char[] tasks, int n) {
        //to store frequency of the tasks
        HashMap<Character, Integer> map = new HashMap<>(); //[{A:3, B:3}]
        int maxFreq = 0; //3
        for(char c: tasks){
            map.put(c, map.getOrDefault(c, 0)+1);
            maxFreq = Math.max(maxFreq, map.get(c)); //3
        }

        int maxCount = 0; //2 -> Both A and B have maxFreq
        //do we have more maxFreq
        for(char c: map.keySet()){
            if(map.get(c) == maxFreq){
                //increment if found more than 1 task having maxFreq
                maxCount++;
            }
        }
        int partitions = maxFreq-1; //[A _ _ |A _ _ |A _]
        int availableSlots = partitions * (n - (maxCount-1)); //2 * (2-(2-1)) --> 2
        int pending = tasks.length - (maxFreq * maxCount); //6 - (3*2) --> 0
        int idle = Math.max(0, availableSlots - pending); //MAX(0, 2-0) --> 2

        return tasks.length + idle; //6+2 --> 8
    }
}