// Time Complexity : O(n)
// Space Complexity : O(n)
// Method used : Greedy

class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        if(tasks == null || tasks.length == 0) return 0;

        HashMap<Character, Integer> map = new HashMap();

        int maxFreq, maxCount;
        maxFreq = maxCount = 0;

        // Maintain the frequency of all the tasks
        for(int i = 0; i < tasks.length; i++)
        {
            map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);

            maxFreq = Math.max(maxFreq, map.get(tasks[i]));
        }

        // Iterate the map once again to check how many tasks are there with max frequency
        for(char key : map.keySet())
        {
            if(map.get(key) == maxFreq) ++maxCount;
        }

        int partitions = maxFreq - 1;
        int emptySlots = partitions * (n - (maxCount - 1));
        int pendingTasks = tasks.length - (maxFreq * maxCount);
        int idleTime = Math.max(0, emptySlots - pendingTasks);

        return tasks.length + idleTime;
    }
}