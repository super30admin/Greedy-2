// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxFreq = 0;
        for(char task : tasks){
            if(!map.containsKey(task)){
                map.put(task,0);
            }
            int cnt = map.get(task);
            cnt++;
            maxFreq = Math.max(maxFreq, cnt);
            map.put(task, cnt);
        }
        int maxCount = 0;
        for(Character task : map.keySet()){
            if(map.get(task) == maxFreq){
                maxCount++;
            }
        }
        int partitions = maxFreq - 1;
        int available = partitions * (n - (maxCount - 1));
        int pending = tasks.length - (maxFreq * maxCount);
        int empty = Math.max(0,available - pending);
        return tasks.length + empty;
    }
}