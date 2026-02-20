// Time Complexity : O(n^2) -> adding at index i is O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// The relative position of the tallest people is fixed
// We sort the array in descending order of height and ascending order of k
// We insert the tall people first and then short people at the kth index
//  This ensures the smaller people inserted later doesnt affect the position of the taller people

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0])
                return a[1] - b[1];
            return b[0] - a[0];
        });

        List<int[]> li = new ArrayList();
        for (int[] p : people)
            li.add(p[1], p);

        return li.toArray(int[][]::new);
    }
}