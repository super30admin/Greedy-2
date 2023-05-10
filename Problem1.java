//Time -> O(n^2)
//Space -> O(1)

class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxFreq = 0; 
        int maxCount = 0; 
        for(char task: tasks){
            map.put(task, map.getOrDefault(task, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(task));
        }
        for(char task: map.keySet()){
            if(maxFreq == map.get(task)){
                maxCount++;
            }
        }
        int partitions = maxFreq - 1; 
        int available = partitions * (n -(maxCount - 1)); 
        int pending = tasks.length - maxFreq * (maxCount);
        int idle =  Math.max(0, available - pending);
        return tasks.length + idle;
        }
}