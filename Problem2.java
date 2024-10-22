// Time Complexity : O(n^2) 
// Space Complexity : O(n) - n is length of people
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : used the same logic Jaspinder explained in the class.

package Greedy-2;

public class Problem2 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a,b) ->{ // nlogn
            if(a[0] == b[0]){
                //{7,0},{7,1}
                return a[1] - b[1];
            }
            //{7,0},{5,1}
            return b[0] - a[0];
        });

        List<int []> q = new ArrayList<>();
        for(int [] person: people){ //O(n^2)
            //add based on the position
            q.add(person[1], person);
        }
        int [][] res = new int[q.size()][2];
        for(int i = 0; i < res.length; i++){ //O(n)
            res[i] = q.get(i);
        }
        return res;
    }
}
