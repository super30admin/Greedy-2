// Time Complexity: O(n)
// Space Complexity: O(1) as constant 26 alphabets
public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        if(tasks == null || tasks.length == 0)
            return 0;
        
        Map<Character, Integer> map = new HashMap<>();
        int maxFreq = 0 , maxCount = 0;
        
        // calculate count of tasks and freq, find max freq
        for(char c : tasks)
        {
            map.put(c, map.getOrDefault(c, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(c));
        }
        // find how many have max freq
        
        for(Character c : map.keySet())
        {
            if(maxFreq == map.get(c))
                maxCount++;
        }
        
        // number of gaps created
        int slots = maxFreq - 1;
        // for same freq we will consider them as unit which reduces n's value
        int emptySlots = slots * (n - (maxCount -1));
        // reduce counts from all maxs arranged
        int availableTasks = tasks.length - maxFreq * maxCount;
        // if we have emptySlots > availableTasks 
        //means we have not enough tasks available to fill all empty slots
        int idle = Math.max(0, emptySlots-availableTasks);
        
        return tasks.length+ idle;
    }
}