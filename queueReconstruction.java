// Time Complexity : O(n^2 * log(n))
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/*
 * Sort the array based on heights of the people in descending order.
 * For each people[i], insert the people[i] at correct position based on number of people in front of a person.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });
        int n = people.length;
        List<int[]> list = new ArrayList<>();
        int[][] result = new int[n][2];
        for(int i=0; i<n; i++){
            int idx = people[i][1];
            list.add(idx, people[i]);
        }

        int i=0;
        for(int[] person : list){
            result[i++] = person;
        }
        return result;
    }
}