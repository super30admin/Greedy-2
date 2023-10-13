// Time Complexity : O(n) // for hashmap
// Space Complexity : O(1) // map can have at most 26 characters
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxFreq=0;
        int maxCount=0;
        // Frequency map and find the maximum Frequency out of all jobs
        for(int i=0 ; i< tasks.length; i++)
        {
            
            map.put(tasks[i], map.getOrDefault(tasks[i],0)+1);  
            int count = map.get(tasks[i]);
            maxFreq = Math.max(maxFreq, count);
        }
        // Find the no.of jobs that has max Frequency
        for(Character ch : map.keySet()){
            if( map.get(ch) == maxFreq ){
                maxCount++;
            }
        }
        int partitions = maxFreq-1; // A _ _ A. // if two jobs and 2 units cool down period partition is 1
        int available = partitions*(n-(maxCount-1));  // find the available slots 
        int pending = tasks.length - (maxCount*maxFreq); // find the remaining tasks
        // find the empty slots. It can be negative when it doesn't have empty slots so take 0
        int emptySlots = Math.max(0, available-pending); // find the empty slots

        return  tasks.length+emptySlots;
    }
}