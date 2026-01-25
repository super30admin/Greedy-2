// Time Complexity : O(n^2) -> O(n log n) to sort and O(n^2) to insert at a certain pos in the array
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this: No


// Your code here along with comments explaining your approach
// 1: We first sort the array in descending order by height, and if heights match then by ascending order of the people in front of them
// 2: Then based on the number of people ahead of them, we insert each person at that index in the array
// 3: We convert the ArrayList to an integer array and return the result
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a,b)-> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });

        List<int[]> result = new ArrayList<>();
        for(int[] person: people){
            // adding at a specific index
            result.add(person[1], person);
        }
        return result.toArray(new int[people.length][2]);
    }
}