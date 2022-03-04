import java.util.HashMap;
import java.util.Map;

// Time Complexity : Add : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class TaskScheduler {
    public static void main(String[] args) {
        char[] tasks = {'A','A','A','B','B','B'};
        int n = 2;
        leastInterval(tasks, n);
    }

    public static int leastInterval(char[] tasks, int n) {

        int result = 0;

        Map<Character, Integer> map = new HashMap<>();
        int maxFreq = 0;
        int maxCount = 0;

        for(char task: tasks){
            int cnt = map.getOrDefault(task, 0)+1;
            maxFreq = Math.max(maxFreq, cnt);
            map.put(task, cnt);
        }

        for(char task: map.keySet()){
            if(maxFreq == map.get(task))
                maxCount++;
        }

        int partition = maxFreq - 1;
        int availableSpace = partition * (n - (maxCount-1));
        int pendingTasksToBeOccupied = tasks.length - (maxFreq * maxCount);
        int idle = Math.max(0, availableSpace - pendingTasksToBeOccupied);

        return tasks.length + idle;


    }
}

