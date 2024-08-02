// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxFreq = 0;
        int maxCount = 0;

        for(int i=0; i< tasks.length; i++){
            char c = tasks[i];
            map.put(c, map.getOrDefault(c,0) + 1);
            maxFreq = Math.max(maxFreq, map.get(c));
        }

        for(char key : map.keySet()){
            if(map.get(key) == maxFreq){
                maxCount++;
            }
        }
        int partitions = maxFreq - 1;
        int empty = partitions * (n - (maxCount -1 ));
        int pending = tasks.length - maxFreq*maxCount;
        int idle = Math.max(0, empty - pending);
        return tasks.length + idle;
        
    }
}