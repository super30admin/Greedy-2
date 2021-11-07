// Time Complexity: O(2n)
// Space: O(n)
// Idea here is to make partitions based on max frequency as we will fill in other tasks between them
// we can calculate empty spaces according to partitions times cooldown period
// pending are tasks remaining if we club all the max freq tasks
// idle time is cool down period after consecutive tasks are completed.
class Solution {
    public int leastInterval(char[] tasks, int n) {
        if(tasks.length==0 || tasks==null) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int maxFreq = 0;
        for(int i = 0; i<tasks.length; i++) {
            map.put(tasks[i], map.getOrDefault(tasks[i], 0)+1);
            maxFreq = Math.max(maxFreq, map.get(tasks[i]));
        }
        int maxCount = 0;
        for(char key: map.keySet()) {
            if(map.get(key)== maxFreq) {
                maxCount++;
            }
        }
        
        int partitions = maxFreq-1;
        int empty = partitions*(n-(maxCount-1));
        int pending = tasks.length - (maxCount*maxFreq);
        int idle = Math.max(0, empty-pending);
        return tasks.length+idle;
    }
}