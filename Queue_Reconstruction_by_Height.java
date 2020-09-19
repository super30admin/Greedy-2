// Time Complexity : O(n^2 + n logn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.*;

public class Queue_Reconstruction_by_Height {
	public int[][] reconstructQueue(int[][] people) {
		//sort the array first based on height
		// Ip: [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
		//sort : [[7,0],[7,1],[6,1],[5,0],[5,2],[4,4]]
		Arrays.sort(people, (a,b) ->{
			if(a[0] == b[0])
				return a[1] - b[1];

			return b[0] - a[0];
		});

		// now place the above sorted array according to index
		// Op: [[[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]]
		List<int[]> result = new ArrayList<>();
		for(int i=0; i<people.length; i++){
			int[] person = people[i];
			result.add(person[1], person);
		}
		return result.toArray(new int[0][]);
	}
}
