// Time Complexity : O(n)
// Space Complexity : O(1)

class Solution {
    public int leastInterval(char[] tasks, int n) {
        if(tasks == null || tasks.length == 0)
            return 0;
        Map<Character, Integer> map = new HashMap<>();
        int maxFreq = 0;
        int maxCount = 0;
        
        for(char task : tasks){
            int cnt = map.getOrDefault(task, 0);
            cnt++;
            maxFreq = Math.max(maxFreq, cnt);
            map.put(task, cnt);
        }
        
        for(char task : map.keySet()){
            if(map.get(task) == maxFreq)
                maxCount++;
        }
        
        int intervals = maxFreq - 1;
        int available = intervals * (n - maxCount + 1);
        int tobeFilled = tasks.length - (maxFreq * maxCount);
        int idle = Math.max(0, available - tobeFilled);
        
        return tasks.length + idle;
    }
}