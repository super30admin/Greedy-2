// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.*;

public class PartitionLabels {
	 public List<Integer> partitionLabels(String s) {
	        List<Integer> result=new ArrayList<>();
	        int start=0;
	        int end=0;
	        int i=0;
	        while(i<s.length()){
	            if(i>end){
	                result.add(end-start+1);
	                start=end+1;
	            }
	            char c=s.charAt(i);
	            int curr=s.lastIndexOf(c);
	            if(curr>end){
	                end=curr;
	            }
	            i++;
	        }
	        result.add(end-start+1);
	        return result;
	    }
}
