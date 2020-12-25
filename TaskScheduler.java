package Dec24;

import java.util.HashMap;
import java.util.Map;

class TaskScheduler {
	
    public int leastInterval(char[] tasks, int n) {
        
        /*
        Time complexity: O(n) because we are iterating through tasks array once to create freq map and find max freq character using maxFreq variable. 
        Iterating through hashmap to find the no.of character(/s) which has/have highest frequency(maxFreq) - constt.time operation because it can contain at max 26 characters.
        Space complexity: O(1) because using a hashmap but it can at max contain only 26 characters.
        
        Approach:
        
        If highest freq characters are more than 1, and count of max freq characters is maxCount:
        
        Partitions = maxFreq-1
        Empty spots = n*partitions MODIFIED TO partitions*(n-maxCount+1)
        Pending tasks= tasks.length - maxFreq MODIFIED TO tasks.length - (maxFreq*maxCount)
        Idle spots= empty spots-pending tasks MODIFIED TO max(0, empty spots-pending tasks)
        
        Answer will be tasks.length+idle spots. Note that main focus in this question is to find number of idle spots.
        
        */
        
        // put each character with its freq in hashmap and find max freq character using maxFreq variable 
        Map<Character, Integer> map = new HashMap<>();
        int maxFreq = 0; // max no.of times that the highest freq element is present in given array
        for (char c: tasks) {
            int count = map.getOrDefault(c, 0);
            map.put(c, count+1);
            maxFreq = Math.max(maxFreq, count + 1);
        }
        
        // find the no.of character(/s) which has/have highest frequency(maxFreq)
        int maxCount = 0;
        for (char c: map.keySet()) {
            if (map.get(c) == maxFreq) {
                maxCount++;
            }
        }
        
        // apply the formulae
        int partitions = maxFreq - 1;
        int empty = partitions * (n-maxCount+1);
        int pending = tasks.length - (maxFreq * maxCount);
        int idle = Math.max(0, empty-pending);
        
        return tasks.length+idle;
        
    }
}