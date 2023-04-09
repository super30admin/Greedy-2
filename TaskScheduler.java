import java.util.*;
public class TaskScheduler {
    //TC=O(n) SC=O(1)
    public int leastInterval(char[] tasks, int n) {
        int no_of_task=tasks.length;
        HashMap<Character,Integer> map = new HashMap<>();
        int maxFreq = 0;
        int maxCount = 0;
        for(char task:tasks){
            if(!map.containsKey(task)){
                map.put(task,0);
            }
            int cnt = map.get(task);
            cnt++;
            map.put(task,cnt);
            maxFreq = Math.max(maxFreq,cnt);
        }
        for(Character task:map.keySet()){
            if(map.get(task)==maxFreq){
                maxCount++;
            }
        }
        int partitions = maxFreq-1;
        int available_slots = partitions*(n-(maxCount-1));
        int pending = no_of_task-(maxFreq*maxCount);
        int empty = Math.max(0,available_slots-pending);

        return no_of_task+empty;
    }
}
