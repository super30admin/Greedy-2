// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach

// We do this using Greedy approach
// We sort the array based descending order of the height ans ascending order of no of people before
// Then we add the people onto the list at postion people[1]

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0)
            return new int[0][];
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });

        List<int[]> result = new ArrayList<>();
        for (int[] person : people) {
            result.add(person[1], person);
        }
        return result.toArray(new int[0][]);
    }
}