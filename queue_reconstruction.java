// Time Complexity :O(n^2)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        List<int[]> res = new ArrayList<>();
        int[][] temp = new int[res.size()][2];
        // sort wrt height in desc and no of people asc
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });
        // insert at index person[1]
        for (int i = 0; i < people.length; i++) {
            int[] person = people[i];
            res.add(person[1], person);
        }
        return res.toArray(people);
    }
}