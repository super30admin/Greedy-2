/*
 * TC = O(N)
 * SC = O(N)
 * 
 * We take the most freq occuring character and place gaps of size n in between them.
 * This is to ensure we use the cooling period only less times. 
 * Then we fill the other elements accordingly.
 */
import java.util.*;
public class TaskScheduler
{
    public static int leastInterval(char[] tasks, int n) {
        if(tasks == null || tasks.length == 0) return 0;
        
        int maxFreq=0,maxCount = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i =0;i<tasks.length;i++)
        {
            char c = tasks[i];
            map.put(c,map.getOrDefault(c,0)+1);
            maxFreq = Math.max(maxFreq,map.get(c));
            
        }
        
        for(char c: map.keySet())
        {
            if(maxFreq == map.get(c))
            {
                maxCount++;
            }
        }
        
        int partitions = maxFreq - 1;
        int empty = partitions * (n - (maxCount - 1));
        int pendingTasks = tasks.length  - (maxFreq * maxCount);
        int idle = Math.max(0,empty - pendingTasks); 
        
        return tasks.length + idle;
    }

    public static void main(String args[])
    {
        char[] tasks = {'A','A','A','A','B','B','B'};
        System.out.println(leastInterval(tasks, 2));
    }
}