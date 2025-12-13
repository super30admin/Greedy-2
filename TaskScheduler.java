// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Approach : We capture the frequency of each character by mapping them in hashmap. We capture the number of maxLengthChars as well by looping over the hashMap.
// Now, the intuition is to start by placing the maximum repeated ones with n spaces between them and filling out. So we calculate the partitions which will be
// max-1. Then we calculate the number of available slots, pending slots and idle slots after placing the maximum repeated ones with n spaces between them. Some
// scenarios where the n is lower or maxLengthChars are only present in input, the idleslots value can go negative. So we consider only if its positivw, else 0.The
// result will be the sum of idle and total length of tasks array.

class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int maxLengthChars = 0;
        for(int i = 0; i < tasks.length; i++){
            map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1); //capture the frequencies of each character
            max = Math.max(max, map.get(tasks[i])); //capture the max frequency
        }
        for(char ch : map.keySet()){
            if(map.get(ch) == max){
                maxLengthChars++; //capture the max frequency characters count
            }
        }
        int partitions = max - 1; //number of partitions
        int availableSlots = partitions * (n - (maxLengthChars - 1));
        int pendingTasks = tasks.length - (max * maxLengthChars);
        int idleSlots = Math.max(0, availableSlots - pendingTasks);
        return tasks.length+idleSlots;
    }
}