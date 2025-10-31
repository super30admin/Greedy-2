// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
//Sort the people in decreasing order of thier height if same height sort them on increasing order of k value
//Then we insert each person at the index equal to how many taller or equal people should be in front of them.
//Since taller people are already placed, inserting at that index ensures everyone sees exactly the number of taller or equal people they expected.
class Solution {
    public int[][] reconstructQueue(int[][] people) {

        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0])
                return a[1] - b[1]; //of the heights are same sort on k
            return b[0] - a[0];
        });

        List<int[]> res = new ArrayList<>();
        for (int[] person : people) {
            res.add(person[1], person); //add person at that index
        }

        //convert arraylist to int[]
        return res.toArray(new int[0][0]);
    }
}
