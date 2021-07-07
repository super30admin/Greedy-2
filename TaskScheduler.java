// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

//Time Complexity : O(n) since we are iterating through the tasks Array and map linearly
//Space Complexity: O(n) since we are using an extra HashMap 

class Solution {
    public int leastInterval(char[] tasks, int n) {
                
        //Ex : AAABBC, n=2
        // All the maximum count tasks are placed initially
        //A _ _ A _ _ A
        // partitions = maxFrequency - 1  => 3 - 1 = 2
        // available =  n - (number of items with maximum frequency) * parititions => 2 * 2 = 4 
        // pending = tasks.length - maxFrequency => 6 - 3 = 3
        // idle = available - pending => 4 - 3 = 1 (null), if negative take 0
        
        if(tasks == null || tasks.length == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < tasks.length; i++){
            map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);
        }

        int maxCount = Integer.MIN_VALUE;
        for(int j : map.values()){
            maxCount = Math.max(maxCount, j);
        }
        int maxFreq = 0;
        for(int k : map.values()){
            if(k == maxCount){
                maxFreq++;
            }
        }
        
        int partitions = maxCount - 1;
        int available = (n-(maxFreq - 1)) * partitions;
        int pending = tasks.length - (maxCount * maxFreq);
        int idle = Math.max(0, available - pending);
        
        return tasks.length + idle;        
    }
}