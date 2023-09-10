// Time Complexity : O(N^2)
// Space Complexity : O(N) for arraylist to store the result
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/*
 * First we custom sort the array by in descending order of height and if heights are equal ascending order of people infront
 * as we settle the indices for tall people first then keeping short people infornt of tall people does not affect the already people in the queue.
 */



import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a,b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });

        List<int[]> q = new ArrayList<>();
        for(int i=0; i<people.length; i++){
            q.add(people[i][1], people[i]);
        }
        int[][] result = new int[people.length][2];
        for(int i=0; i< people.length; i++){
            result[i] = q.get(i);
        }
        return result;
    }
}