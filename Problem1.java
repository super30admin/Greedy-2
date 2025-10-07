
// Time Complexity: O(N) where N is the number of tasks
// Space Complexity: O(1) since the size of the hashmap will be at most 26 (for each letter in the alphabet)

//We use greedy approach to solve this problem.
//The idea is to always try to schedule the most frequent task first.
//we can use a hashmap to store the frequency of each task. Then we can find the maximum frequency and the number of tasks that have that maximum frequency.
//Then we can calculate the number of partitions we need to create and the number of available slots
//Then we can calculate the number of pending tasks and the number of idle slots we need to fill.
//Finally we can return the total number of tasks plus the number of idle slots.

class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character,Integer> map=new HashMap<>();
        int maxFreq=0,maxCount=0;
        for(char c:tasks){
            map.put(c,map.getOrDefault(c,0)+1);
            maxFreq=Math.max(maxFreq,map.get(c));
        }
        for(char c:map.keySet()){
            if(map.get(c)==maxFreq)
                maxCount++;
        }
        int partitions=maxFreq-1;
        int available=partitions*(n-(maxCount-1));
        int pending=tasks.length-(maxFreq*maxCount);
        int idle=Math.max(0,available-pending);
        return tasks.length+idle;
    }
}