// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// We use greedy approach here
// Tasks with maximum frequency are the bottleneck tasks
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int maxFreq = 0, maxCount=0;
        int len = tasks.length;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<len;i++){
            map.put(tasks[i], map.getOrDefault(tasks[i],0)+1);
            maxFreq = Math.max(maxFreq, map.get(tasks[i]));}
            for(char key: map.keySet()){
                if(map.get(key)==maxFreq) maxCount++;
            }
            int partitions = maxFreq-1;
            int available = partitions*n - (maxCount-1)*partitions;
            int pending = len - maxCount*maxFreq;
            int idle = Math.max(0, available-pending);
            return len+idle;
    }
}