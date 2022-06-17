class taskScheduler {
    public int leastInterval(char[] tasks, int n) {
        if(tasks == null || tasks.length == 0) return 0;
        
        HashMap<Character, Integer> map = new HashMap();
        int maxFreq = 0, maxCount = 0;
        
        for(int i = 0; i < tasks.length; i++){
            char c = tasks[i];
            map.put(c, map.getOrDefault(c, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(c));
        }
        
        for(char c : map.keySet()){
            if(maxFreq == map.get(c)){
                maxCount++;
            }
        }
        
        int partitions = maxFreq - 1;
        int empty = partitions * (n - (maxCount - 1));
        if(empty <= 0) return tasks.length;
        int pendingTasks = tasks.length - (maxFreq * maxCount);
        int idle = Math.max(0, empty - pendingTasks);
        
        return tasks.length + idle;
    }
}

//time complexity O(n)
//space complexity O(1)