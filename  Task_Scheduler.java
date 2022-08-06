class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        HashMap<Character,Integer> map =new HashMap<>();
        int maxFreq = 0; int maxCount = 0;
        for(char task:tasks){
            int cnt = map.getOrDefault(task,0);
            cnt++;
            maxFreq = Math.max(maxFreq,cnt);
            map.put(task,cnt);
        }
        for(char key:map.keySet()){
            if(map.get(key) == maxFreq){
                maxCount++;
            }
        }
        int partitions = maxFreq - 1;
        int available = partitions * (n - (maxCount-1));
        int pending = tasks.length - (maxFreq * maxCount);
        int idle = Math.max(0,available - pending);
        return tasks.length + idle;
        
    }
}