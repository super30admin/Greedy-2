// Time Complexity : O(n^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Sort the people as per decending order of height, and then ascending order of position
// Add the elements in the result to the position, if the position is to the left of where it should be
// It is moved to the right on next placements
// Finally return the result
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a,b) ->{
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            else
                return b[0] - a[0];
        });
        List<int[]> res = new LinkedList<>();
        for(int[] ppl: people){     
            res.add(ppl[1], ppl);
        }
        return res.toArray(new int[people.length][2]);
    }
}