// Time Complexity : 0(nlogn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if(people == null && people[0].length == 0){
            return null;
        }
        Arrays.sort(people, (a,b) ->{ // sorting
            if(a[0] == b[0]){ // if height is same then sort by number of people in front.
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });
        List<int[]> q = new ArrayList<>();
        for(int[] person : people){
            q.add(person[1], person); // insert the person list in the given position as mentions in the 1th index
        }
        return q.toArray(new int[][] {});
    }
}