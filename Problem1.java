package Greedy-2;
// TC: O(2*n)
// SC: O(n)
public class Problem1 {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxFreq = Integer.MIN_VALUE;
        for(Character c: tasks){
            map.put(c, map.getOrDefault(c, 0)+1);
            maxFreq = Math.max(maxFreq, map.get(c));
        }

        int maxCount=0;
        for(char c: map.keySet()){
            if(map.get(c)==maxFreq) maxCount++;
        }

        int partitions = maxFreq-1; 
        int availableSlots = partitions*(n-(maxCount-1));
        int pendingTasks = tasks.length - (maxFreq * maxCount);
        int idleTime = Math.max(availableSlots - pendingTasks, 0);
        return idleTime + tasks.length; 
    }
}
