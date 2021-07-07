// Time complexity is O(nlogn) + O(n^2) = O(n^2) {n^2 as we shifting values in array}
// Space complexity is O(1)
// This solution is submitted on leetcode

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BigN139QueueReconstructSolution {
	class Solution {
	    public int[][] reconstructQueue(int[][] people) {
	        //edge case
	        if(people == null || people.length == 0)
	            return new int[0][0];
	        Arrays.sort(people, (a,b)-> a[0]== b[0] ? a[1]-b[1] : b[0]-a[0]);
	        List<int []> result = new ArrayList<>();
	        for(int [] person : people){
	            result.add(person[1],person);
	        }
	        return result.toArray(new int[0][]);
	    }
	}
}