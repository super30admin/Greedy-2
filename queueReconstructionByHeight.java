/*
Problem: https://leetcode.com/problems/queue-reconstruction-by-height/
TC: O(n^2)
SC: O(n)
*/
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0) {
            return new int[0][0];
        }
        
        // TC: O(n log n)
        Arrays.sort(people, (p1, p2) -> {
           if (p1[0] == p2[0]) {
               return p1[1] - p2[1];
           } else {
               return p2[0] - p1[0];
           }
        });
        
        // TC: O(n ^ 2) to add at index
        List<int[]> result = new ArrayList<>();
        for (int[] person : people) {
            result.add(person[1], person);
        }
        return result.toArray(new int[result.size()][2]);
    }
}