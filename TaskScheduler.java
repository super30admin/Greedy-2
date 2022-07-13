// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        int maxCount = 0;
        int maxFrequency = 0;
        // we take the frequencies of all the tasks
        for(char task: tasks) {
            int freq = map.getOrDefault(task, 0);
            freq++;
            maxFrequency = Math.max(maxFrequency, freq);
            map.put(task, freq);
        }
        // we take the counts of tasks that have the similar maxFrequencies
        for(char e : map.keySet()) {
            if(map.get(e) == maxFrequency)
                maxCount++;
        }
        // we first consider like we place the most frequent task, leaving N spaces inbetween
        // then we fill in all the other tasks accordinly
        int partition = maxFrequency-1;
        int available = partition*(n-(maxCount -1));
        int pending = tasks.length - (maxFrequency*maxCount);
        int idle = Math.max(available-pending, 0);
        // finally, we find all the idle spots + the actual no of spots required
        return tasks.length+idle;
    }
}