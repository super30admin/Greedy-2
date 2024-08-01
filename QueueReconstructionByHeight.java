// Time Complexity : O(n^2)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// Sort People: Sort the array of people in descending order by height, and for people with the same height, sort them in ascending order by the number of people in front.
//Insert into Queue: Iterate through the sorted array and insert each person at the index specified by the number of people in front.
//Return Result: Convert the list to a 2D array and return it as the reconstructed queue.

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0) {
            return new int[][] {};
        }
        int n = people.length;
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) { // 7 = 7
                return a[1] - b[1]; // ascending order -> 0 - 1
            }
            return b[0] - a[0]; // decending order
        });

        List<int[]> q = new ArrayList<>();
        for (int[] person : people) {
            q.add(person[1], person);
        }
        return q.toArray(new int[][] {});
    }
}