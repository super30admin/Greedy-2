// Time Complexity : O(n)
// iterating over map.keySet() is O(26) only.
// Space Complexity : O(1) Since at the max only 26 characters will be stored in hash map.
// Did this code successfully run on Leetcode : Yes

import java.util.HashMap;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int result = 0;
        int maxFreq = 0;
        int maxCount = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0; i< tasks.length; i++){
            map.put(tasks[i],map.getOrDefault(tasks[i],0)+1);
            maxFreq = Math.max(maxFreq,map.get(tasks[i]));
        }

        for(char key : map.keySet()){
            if(map.get(key) == maxFreq){
                maxCount++;
            }
        }

        int partitions = maxFreq - 1;
        int available = (n-(maxCount-1)) * partitions;
        int pending = tasks.length - maxFreq*maxCount;
        int idle = Math.max(0, available - pending);

        result = tasks.length + idle;
        return result;
    }
}
