// Time Complexity: O(n^2)
// Space Complexity: O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if(people == null) 
            return new int[0][0];
        List<int[]> q = new ArrayList<>();
        Arrays.sort(people, (a, b) -> {
            if(a[0] == b[0]) return a[1] - b[1];
            return b[0] - a[0];
        });
        
        for(int i = 0; i < people.length; i++) {
            int[] person = people[i];
            q.add(person[1], person);
        }
        return q.toArray(new int[0][]);
    }
}