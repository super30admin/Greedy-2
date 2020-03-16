/*
Time Complexity : O(n) 
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this: none
*/
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0) return new int[0][0];
        Arrays.sort(people, (a,b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        
        for (int[] p: people)
            System.out.print("[" + p[0] + "," + p[1] + "] ");
        List <int[]> result = new ArrayList<>();
        for (int[] persons: people)
        {
            result.add(persons[1], persons);
        }
        
        return result.toArray(new int[0][]);
    }
}