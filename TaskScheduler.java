// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.HashMap;

public class TaskScheduler {
	 public int leastInterval(char[] tasks, int n) {
	        HashMap<Character,Integer> map=new HashMap<>();
	        int maxFrequency=0;
	        int maxCount=0;
	        for(char c: tasks){
	            map.put(c,map.getOrDefault(c,0)+1);
	            maxFrequency=Math.max(maxFrequency,map.get(c));
	        }
	        
	        for(Character key: map.keySet()){
	            if(map.get(key)==maxFrequency){
	                maxCount++;
	            }
	        }
	        
	        int partitions=maxFrequency-1;
	        int availableSlots=partitions*(n-(maxCount-1));
	        int pendingTasks=tasks.length-(maxCount*maxFrequency);
	        int idleSlots=Math.max((availableSlots-pendingTasks),0);
	        
	        return tasks.length+idleSlots;
	    }
}
