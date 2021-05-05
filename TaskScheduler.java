class TaskScheduler {
    
    // Time Complexity: O(m)    (where m -> length of tasks array)
    // Space Complexity: O(m)   
    
    public int leastInterval(char[] tasks, int n) {
        if(tasks == null || tasks.length == 0 || n < 0)
            return 0;
        
        Map<Character, Integer> map = new HashMap<>();
        int maxFreq = 0;
        int maxCount = 0;
        
        for(char c : tasks){
            map.put(c, map.getOrDefault(c,0)+1);
            maxFreq = Math.max(maxFreq, map.get(c));
        }
        
        for(int val : map.values()){
            if(val == maxFreq)
                maxCount += 1;
        }
        
        int partitions = maxFreq - 1;
        int empty = partitions * (n - maxCount + 1);
        int pending = tasks.length - (maxFreq * maxCount);
        int idle = Math.max(empty - pending, 0);
        
        return tasks.length + idle;
    }
}