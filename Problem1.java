// 621 Task scheduler
// Time - O(n)
// Space - O(1)

class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        HashMap<Character, Integer> map = new HashMap();
        int maxFrequency = 0;
        int maxCount = 0;
        
        for(Character c: tasks){
            
            map.put(c, map.getOrDefault(c, 0) + 1);
            
            if(map.get(c) > maxFrequency){
                maxFrequency = map.get(c);
            }
        }
        
        for(Character key: map.keySet()){
            if(map.get(key) == maxFrequency){
                maxCount++;
            }
        }
        
        int partitions = maxFrequency - 1;
        int availableSlots = partitions * (n - (maxCount - 1));
        int pendingSlots = tasks.length - (maxCount * maxFrequency) ;
        int idleSlots = Math.max(0, availableSlots - pendingSlots);
        
        
        return idleSlots + tasks.length;
        
        
        
    }
}