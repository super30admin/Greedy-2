// Time Complexity : O(N)
// Space Complexity : O(1) //only capital letters
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.HashMap;
import java.util.Map;

public class TaskScheduler {
	public int leastInterval(char[] tasks, int n) {
        Map<Character,Integer> map=new HashMap<>();
        int maxFreq=0;
        for(int i=0;i<tasks.length;i++){
            maxFreq=Math.max(map.compute(tasks[i],(k,v)-> v==null?1:v+1),maxFreq);
        }
        
        int maxcount=0;
        for(Character key:map.keySet()){
            if(map.get(key)==maxFreq) maxcount++;
        }
        
        int partitions= maxFreq-1;
        int available= partitions*(n-(maxcount-1));
        int pending= tasks.length-(maxFreq*maxcount);
        int idle= Math.max(0,available-pending);
        
        return tasks.length+idle;
        
    }
}
