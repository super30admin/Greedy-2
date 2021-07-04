import java.util.*;

public class TaskScheduler {
    
    //Calculate the maximum occurance of the task
    //Assume that we are arranging that task first then inserting the remaining task in between.
    //Steps:
    //Put it in the hashmap and calculate the max occurance 
    // If both tasks shares same max.
    //Calculate the slots in between
    //Calculate the number of empty spaces need to filled
    //Calculate the pending tasks need to be filled - Overall task - remining task.
    //Calculate the idle - Spaces - pending tasks
    //return the idle + total tasks

    //TC:O(N) - O(2N)To find the max occurance and max count we are iterating the array twice.
    //SC:O(N) - O(N) We are using HashMap to save the Char to find the max count.
    public int leastInterval(char[] tasks, int n) {
        
        HashMap<Character,Integer> map =new HashMap();
        int maxOccurance = 0;
        int maxCount = 0;
        for(char task: tasks) {
            int currentCount = map.getOrDefault(task, 0);
            currentCount++;
            maxOccurance = Math.max(maxOccurance, currentCount);
            map.put(task, currentCount);
        }
        
        for(Integer count: map.values()) {
            if(count == maxOccurance) {
                maxCount++;
            }
        }
        
        int slots = maxOccurance - 1;
        int emptySpaces = (n-(maxCount-1))*slots;
        int pendingTasks = tasks.length - (maxCount* maxOccurance);
        int idle = Math.max(0, emptySpaces - pendingTasks);
        return idle+tasks.length;
        
    }

    public static void main(String[] args) {
        TaskScheduler tScheduler = new TaskScheduler();
        int result = tScheduler.leastInterval(new char[]{'A','A','A','B','B'}, 2);
        System.out.println("The result: "+result);
    }
}
