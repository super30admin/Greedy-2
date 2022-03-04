package greedy2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueueReconstructionByHeight {
	//Time Complexity : O(n^2), where n is the length of people array
	//Space Complexity : O(n)
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public int[][] reconstructQueue(int[][] people) {
        // null
        if(people == null || people.length == 0)
            return new int[0][0];
        
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        
        List<int[]> recon = new ArrayList<>();
        
        for(int[] person: people)
            recon.add(person[1], person);
        
        return recon.toArray(new int[recon.size()][2]);
    }
}
