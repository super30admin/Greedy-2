// Time Complexity : O(n^2) + O(nlogn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public int[][] reconstructQueue(int[][] people) {

        ArrayList<int[]> list = new ArrayList();

        //sort the array according to descending order of height

        Arrays.sort(people, (a, b) -> {

            //height is same, sort in ascending order of people they want in front
            if(a[0]==b[0])
                return a[1]-b[1];

            return b[0]-a[0];

        });

        for(int[] person : people) {

            //place at index which is number of people this person wants in front (0 based index)
            list.add(person[1], person);
        }

        return list.toArray(people);

    }
}
