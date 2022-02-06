// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// Sort in the descending order of height (people[0]) and ascending order of the no. of people ahead of it (people[1])
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if(people == null || people.length == 0) return new int[0][];
        Arrays.sort(people, (a,b) -> {
            if(a[0] == b[0]) {
                return a[1]-b[1];
            }
            return b[0]-a[0];
        });

        ArrayList<int[]> result = new ArrayList<>();
        for (int[] person: people) {
            result.add(person[1], person);      // the firse value is the index of where to place the person, in this case it is the value at person[1]
        }

        return result.toArray(new int[0][]);
    }
}