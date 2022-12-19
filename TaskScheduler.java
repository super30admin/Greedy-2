// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : YEs
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
/*
 * 1 - Pick the task having maximum frequency in occurence.
 * 2 - If there is more than one task which has max frequency, group them together and treat it as one single unit.
 * 3 - In the empty slots, place any remaining task. Calculate number of empty slots in the end.
 */
import java.util.HashMap;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character,Integer> map = new HashMap<>();
        int maxFreq = 0;
        int maxCount = 0;
        
        for(char task:tasks)
        {
            int count = map.getOrDefault(task,0);
            count++;
            maxFreq = Math.max(maxFreq,count);
            map.put(task,count);
        }
        
        for(char key:map.keySet())
        {
            if(map.get(key) == maxFreq)
            {
                maxCount++;
            }
        }
        
        int partition = maxFreq - 1;
        int aSlots = partition * (n - (maxCount - 1));
        int pSlots = tasks.length - (maxCount*maxFreq);
        int idle = Math.max(0,aSlots-pSlots);
        return tasks.length + idle;
    }
}
