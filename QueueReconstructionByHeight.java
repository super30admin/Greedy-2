/*
 * #406. Queue Reconstruction by Height
 * 
 * Suppose you have a random list of people standing in a queue. 
 * Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. 
 * Write an algorithm to reconstruct the queue.

Note:
The number of people is less than 1,100.

 
Example

Input:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

Output:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]

 */


/*
 *	Time Complexity: O (N logN) -> Sorting using custom comparator
 *
 *  Space Complexity: O (1) -> No extra space used
 * 
 *  Did this code successfully run on leetcode: Yes
 * 
 *  Any problem you faced while coding this: No
 * 
 */

package com.s30.edu.greedy3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueueReconstructionByHeight {
	public int[][] reconstructQueue(int[][] people) {
        
        /*
        *   #1. Custom comparator for sorting
        *           1. Sort the pairs (h,k) based on height 'h' in DESC order
        *           2. While doing 1st step, sort the pairs with equal heights 'h' based on value of 'k' in ASC order
        *   #2. After sorting, traverse the sorted pairs (h,k), and shift them to appropriate place/index -> value of 'k', and add to output list
        *   #3. Convert the output list to 2D array and return it
        */
        
		
		
        // #1. Custom comparator
        /*
        *   (a,b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0] // Lambda expression
        *   (a,b) -> e.g: a - [7,0], b - [7,1]
        *   a[0] == b[0] -> If heights are equal, then sort based on 'k' in ASC order, a[1] - b[1] -> if this answer is negative, a[1] comes first, if answer is positive, b[1] comes first
        *   else, for different heights, e.g: a - [7,0], b - [4,4], sort based on 'h' in DESC order -> b[0] - a[0], If answer is negative a[0] comes first, if answer is positive, b[0] is greater, it comes first 
        *
        */
        Arrays.sort(people, (a,b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]); // O (N logN)
        
        // #2. Create a output list
        List<int[]> output = new ArrayList<int[]>();
        
        // #3. Traverse the sorted pairs and shift them to appropriate index -> value of 'k', and add to output list
        /*
        *   Shifting elements in a list for large number of indices takes O (N) time
        *   Shifting elements in a list for arbitrary indices takes O (1) time
        *   In our case, it will be O (1)
        */
        for(int[] p : people){ // traverse through each pair [h,k] in sorted "people" array
            output.add(p[1], p); // (p[1] -> value of 'k'/index, p -> pair(h,k)), shifting in a list step, O (1)
        }
        
        // #4. Convert list to array and return it as output
        return output.toArray(new int[0][]);
        
    }

}
