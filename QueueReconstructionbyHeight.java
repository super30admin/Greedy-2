// In this approach, we are first sorting the people array in descending order of their heights and then placing the people one by 
// one in result list at the index which it has with itself (i.e. the number of people in front is our index for result list)

// Time Complexity : O(n^2) becoz adding to the result list based on index so we might push n elements back in worst case
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // Base case
        if (people == null || people.length == 0) {
            return new int[][] {};
        }
        // Sort the people array in descending order of the people's height
        Arrays.sort(people, (a, b) -> {
            // If two people have same height, then arrange them in ascending order of
            // number of people in front of them
            if (a[0] == b[0]) {
                // Index 1 has that information of number of people in front
                return a[1] - b[1];
            }
            // Else, if height is not same then arrange in descending order of their heights
            return b[0] - a[0];
        });
        // Declare result list
        List<int[]> q = new ArrayList<>();
        // Now iterate through that sorted order and put them in result list at the
        // index which it has with it
        for (int[] person : people) {
            // At person[1] we have that index
            q.add(person[1], person);
        }
        // Convert the result list to array and return
        return q.toArray(new int[][] {});
    }
}