import java.util.HashMap;

class Solution {
    public int leastInterval(char[] tasks, int n) 
    {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxCount = 0;
        int maxFreq = 0;
        for(int i = 0; i < tasks.length; i++) 
        {
            if(map.containsKey(tasks[i])) 
            {
                int count = map.get(tasks[i]) + 1;
                if(count > maxFreq) 
                {
                    maxFreq = count;
                }
                map.put(tasks[i], count);
            }
            else {
                map.put(tasks[i], 1);
            }
        }

        for(int val : map.values()) 
        {
            if(val == maxFreq) {
                maxCount++;
            }
        }

        int partCount = maxFreq - 1;

        int emptySlots = (n - (maxCount - 1)) * partCount;

        int availableSlots = tasks.length - (maxCount * maxFreq);

        int idle = Math.max(0, emptySlots - availableSlots);  

        return tasks.length + idle;

    }
}