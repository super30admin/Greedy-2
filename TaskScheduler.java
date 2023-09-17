import java.util.HashMap;
import java.util.Map;

public class TaskScheduler {
    //Time Complexity: O(N)
    //Space Complexity: O(N)
    public int leastInterval(char[] tasks, int n) {
        int maxFreq = 0;
        Map<Character, Integer> map = new HashMap<>();

        for(int i =0; i< tasks.length; i++){
            map.put(tasks[i], map.getOrDefault(tasks[i], 0)+1);
            maxFreq = Math.max(maxFreq, map.get(tasks[i]));
        }
        // no of jobs with max frequency
        int noOfTasks = 0;
        for(char task: map.keySet()){
            if(map.get(task) == maxFreq){
                noOfTasks++;
            }
        }
        int noOfPartitions = maxFreq - 1;
        int available = noOfPartitions * (n - (noOfTasks - 1));
        int remaining = tasks.length - (noOfTasks*maxFreq);
        int extra = Math.max(0, available - remaining);

        return extra + tasks.length;
    }
}
