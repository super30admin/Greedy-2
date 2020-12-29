//Time Complexity : O(n^2)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : None

package com.s30.satish;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Queue_Reconstruction_by_Height_406 {
    public int[][] reconstructQueue(int[][] people) {
        // O(n log n)
        Arrays.sort(people, (a,b) -> 
            {
                if(a[0] == b[0])
                    return a[1] - b[1];
                else
                    return b[0] - a[0];
            });
        List<int[]> list = new ArrayList<>();
        // O(n^2)
        for(int[] persons : people) // O(n)
        {
            list.add(persons[1], persons); //O(n)
        }
//        int[][] result = new int[0][];
//        result = list.toArray(result);
//        return result;
        return list.toArray(new int[0][]);
    }
    public static void main(String[] args)
    {
    	Queue_Reconstruction_by_Height_406 obj = new Queue_Reconstruction_by_Height_406();
    	int[][] arr = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
    	int[][] result = obj.reconstructQueue(arr);
    	for(int i = 0; i < result.length; i++)
    	{
    		for(int j = 0; j < result[0].length; j++)
    		{
    			System.out.print(result[i][j] + " ");
    		}
    		System.out.println("");
    	}
    	
    }
}
