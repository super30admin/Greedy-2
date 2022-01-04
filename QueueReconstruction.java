// Time Complexity : O(NlogN)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.*;

public class QueueReconstruction {
	 public int[][] reconstructQueue(int[][] people) {
	        List<int[]> result=new ArrayList<>();
	        
	        Arrays.sort(people,(a,b)->{
	            if(a[0]==b[0]) return a[1]-b[1];
	            
	            return b[0]-a[0];
	        });
	            
	            for(int i=0;i<people.length;i++){
	                result.add(people[i][1],people[i]);
	            }
	        
	        return result.toArray(new int[people.length][2]);
	    }
}
