package com.exmaple.problems;

import java.util.*;

// Time Complexity : O(N^2 Log N)
// Space Complexity : O(N^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Sort the tallest guys in the ascending order by k-values and then insert them one by one into output queue at the indexes equal to their k-values.

Take the next height in the descending order. Sort the guys of that height in the ascending order by k-values and then insert them one by one into output queue at the indexes equal to their k-values.
 */


public class QueueConstructionByHeight {
	public int[][] reconstructQueue(int[][] people) {
		Arrays.sort(people, (n1, n2) -> (n2[0] == n1[0]) ? n1[1] - n2[1] : n2[0] - n1[0]);
		
		LinkedList<int []> list = new LinkedList<>();
		
		for(int p[] : people) {
			list.add(p[1],p);
		}
		System.out.println(list);
		return list.toArray(new int[people.length][2]);
	}

	public static void main(String args[]) {
		QueueConstructionByHeight construction = new QueueConstructionByHeight();
		int people[][] = { { 7, 0 }, { 4, 4 }, { 7, 1 }, { 5, 0 }, { 6, 1 }, { 5, 2 } };
		people = construction.reconstructQueue(people);

		System.out.println(Arrays.deepToString(people));
	}
}
