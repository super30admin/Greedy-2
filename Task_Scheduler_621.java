//Time Complexity : O(n)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : None

package com.s30.satish;

import java.util.HashMap;

class Task_Scheduler_621 {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxFrequency = 0;
        for(char ch : tasks)
        {
            int count = map.getOrDefault(ch, 0);
            map.put(ch, count +1);
            maxFrequency = Math.max(count + 1, maxFrequency);
        }
        int maxCount = 0;
        for(char ch : map.keySet())
        {
            if(map.get(ch) == maxFrequency)
                maxCount += 1;
        }
        int partitions = maxFrequency - 1;
        int emptySlots = partitions * (n - maxCount + 1);
        int pendingTasks = tasks.length - maxCount * maxFrequency;
        int idleSlots = Math.max(0, emptySlots - pendingTasks);
        return tasks.length + idleSlots;
    }
    public static void main(String[] args)
    {
    	Task_Scheduler_621 obj = new Task_Scheduler_621();
    	char[] ch = {'A', 'A', 'A', 'B', 'B', 'B'};
    	System.out.print(obj.leastInterval(ch, 2));
    	
    }
}
