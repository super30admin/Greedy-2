// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/**
 * First sort the data by height in descending order. If the height is same, then person with less number of people in front of them will come first.
 * Since we care about the relative order of the people, we will iterate over the array and put the people in the position based on how many people are ahead of them.
 * Putting the person on 2nd relative position will make sure that there is one person ahead of them.
 * Since the array was sorted in descending order of the height, person [5,0] will be put ahead of [7,0] in final result.
 *
 */
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                // if the height is same, then person with less number of people with same or more height will come first
                if (a[0] == b[0]) return a[1] - b[1];

                // otherwise they will be sorted in descending order of their height
                return b[0] - a[0];
            }
        });

        List<int[]> res = new ArrayList<>();
        // since we care about the relative order of the people, they will be put into respective positions of how many people are in front of them after they were sorted
        for (int[] person : people) {
            res.add(person[1], person);
        }
        return res.toArray(new int[0][]);
    }
}