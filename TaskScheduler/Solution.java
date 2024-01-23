package TaskScheduler;

import java.util.*;

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Using array
 */

class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        int maxFreq = 0;
        int maxCount = 0;
        int[] arr = new int[26];
        
        for(char c: tasks) {
            arr[c-'A']++;
            int freq = arr[c-'A'];
            
            if(freq > maxFreq) {
                maxFreq = freq;
                maxCount = 1;
            }
            else if(freq == maxFreq) {
                maxCount++;
            }
        }
        
        int partitions = maxFreq - 1;
        int availableSlots = (n - (maxCount-1)) * partitions;
        int pendingSlots = tasks.length - (maxFreq * maxCount);
        int idleSlots = Math.max(0, availableSlots - pendingSlots);
        
        return tasks.length + idleSlots;
    }
}

/**
 * Using HashMap
 */

class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        int maxFreq = 0;
        int maxCount = 0;
        HashMap<Character, Integer> map = new HashMap<>(); 
        
        for(char c: tasks) {
            if(!map.containsKey(c))
                map.put(c, 0);
            int freq = map.get(c) + 1;
            map.put(c, freq);
            
            if(freq > maxFreq) {
                maxFreq = freq;
                maxCount = 1;
            }
            else if(freq == maxFreq) {
                maxCount++;
            }
        }
        
        int partitions = maxFreq - 1;
        int availableSlots = (n - (maxCount-1)) * partitions;
        int pendingSlots = tasks.length - (maxFreq * maxCount);
        int idleSlots = Math.max(0, availableSlots - pendingSlots);
        
        return tasks.length + idleSlots;
    }
}

/**
 * Combined into a single formula above code
 */
class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        if(n == 0) return tasks.length;
        
        int maxFreq = 0;
        int maxCount = 0;
        HashMap<Character, Integer> map = new HashMap<>(); 
        
        for(char c: tasks) {
            if(!map.containsKey(c))
                map.put(c, 0);
            int freq = map.get(c) + 1;
            map.put(c, freq);
            
            if(freq > maxFreq) {
                maxFreq = freq;
                maxCount = 1;
            }
            else if(freq == maxFreq) {
                maxCount++;
            }
        }
        int result = ((n+1)*(maxFreq-1) + maxCount);
        return tasks.length < result ? result : tasks.length;
    }
}
