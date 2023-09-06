// tc : O(n)
// sc : O(1) - maximum you would store only 26 alphabets

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int max=0, maxCount=0;
        int N = tasks.length ; 
        HashMap<Character, Integer> map = new HashMap<>();
        for(char task : tasks){
            map.put(task,map.getOrDefault(task,0)+1);
            max = Math.max(max, map.get(task));
        }
        
        for(char task : map.keySet())
            if(max == map.get(task))
                maxCount++;
        
        int partitions = max-1;
        int pendingingTasks = N - (max*maxCount);
        int emptySlots = partitions * (n-maxCount+1);
        int idle = Math.max(0,emptySlots-pendingingTasks);
        return N+idle;
    }
}
