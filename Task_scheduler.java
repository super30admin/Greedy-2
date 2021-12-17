class Solution {
    public int leastInterval(char[] tasks, int n) {
       if(tasks == null || tasks.length == 0) return 0;
       HashMap<Character, Integer> map = new HashMap<>();
       int maxFreq = 0;
        int maxCount = 0;
        
        for(char task: tasks){
            int cnt = map.getOrDefault(task, 0);
            cnt++;
            maxFreq = Math.max(maxFreq, cnt);
            map.put(task, cnt);
        }
        
        for(int val: map.values()){
            if(val == maxFreq) maxCount++;
        }
        
        int partitions = maxFreq -1;
        int available = (n - (maxCount - 1))  * partitions;
        int pending = tasks.length - (maxFreq * maxCount);
        int idle = Math.max(0, available-pending);
        return tasks.length + idle;
    }
}

//TC : O(2n)
//SC : O(1)
