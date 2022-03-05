//Time complexity : O(n) - to build hashmap
//Space Complexity : O(1) - hashmap of 26 chars at max
//Did it run on leetcode : yes

import java.util.HashMap;
import java.util.Map;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {

        Map<Character, Integer> map = new HashMap<>();
        int maxFreq = 0; int teamSize = 0;
        for(char task : tasks){
            map.put(task,map.getOrDefault(task, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(task));
        }
        for(char task : map.keySet()){
            if(map.get(task) == maxFreq){
                teamSize++;
            }
        }

        int partitions = maxFreq -1;
        int available = partitions * (n - (teamSize - 1));
        int pending = tasks.length - (maxFreq * teamSize);
        int idle = Math.max(0, available - pending);

        return tasks.length + idle;

    }
}
