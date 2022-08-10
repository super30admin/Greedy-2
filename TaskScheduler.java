// Time Complexity : O(n) where n is number of tasks
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

import java.util.*;

class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxFreq = 0; int maxCount = 0;
        for(char task:tasks){
            int cnt = map.getOrDefault(task,0);
            cnt++;
            maxFreq = Math.max(maxFreq, cnt);
            map.put(task, cnt);
        }
        for(char key : map.keySet()){
            if(map.get(key)==maxFreq){
                maxCount++;
            }
        }
        int partitions = maxFreq - 1;
        int available = partitions * (n-(maxCount-1));
        int pending = tasks.length - (maxFreq*maxCount);
        int idle = Math.max(0, available - pending);
        return tasks.length+idle;
    }

    public static void main(String [] args){
        TaskScheduler ts = new TaskScheduler();
        System.out.println(ts.leastInterval(new char[]{'A','A','A','B','B','B'}, 2));
    }
}