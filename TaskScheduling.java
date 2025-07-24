// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach : find the number of tasks repeating max number of times and their frequency. Allocate that task
/// and try to fill the remaining in the partitions formed by allocating the maxFreq task(s). Compute if any idle
/// spaces will be left, based on it compute the max intervals required

class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<tasks.length;i++){
            char curr = tasks[i];
            map.put(curr, map.getOrDefault(curr, 0)+1);
        }
        int maxx = Integer.MIN_VALUE;
        int maxCount = 0;
        for(char curr: map.keySet()){
            int currInt = map.get(curr);
            maxx = Math.max(maxx, currInt);
        }
        for(char curr: map.keySet()){
            int currInt = map.get(curr);
            if(currInt == maxx){
                maxCount++;
            }
        }
        System.out.println(maxx);
        int partitions = maxx-1;
        int available = partitions * (n-(maxCount-1));
        int pending = tasks.length - (maxx * maxCount);
        int idle = Math.max(0, available-pending);
        return tasks.length+idle; 
    }
}