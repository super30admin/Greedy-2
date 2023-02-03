//https://leetcode.com/problems/task-scheduler
//TC: O(n)
//SC: O(n)


class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character,Integer> map = new HashMap<>();
        int maxFreq = 0;
        int maxCount =0;
        
        for(char c : tasks){
            map.put(c,map.getOrDefault(c,0)+1);
            maxFreq = Math.max(maxFreq,map.get(c));
        }
        for(char c : map.keySet()){
            if(maxFreq == map.get(c)){
                maxCount++;
            }
        }
        int partitions = maxFreq-1;
        int availableSlots = partitions * (n-maxCount+1);
        int pendingTasks = tasks.length - (maxCount*maxFreq);
        int idleSlots = Math.max(0,availableSlots-pendingTasks);
        return tasks.length+idleSlots;
    }
}
