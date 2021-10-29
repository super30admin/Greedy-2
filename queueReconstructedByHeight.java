// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        List<int[]> q = new ArrayList<>();
        Arrays.sort(people, (a,b) ->{
            if(a[0] == b[0])
                return a[1] - b[1];
            return b[0] - a[0];
        });
        // place in queue according to height
        // if heights are equal, place according to num of people
        for(int i=0; i < people.length; i++){
            int[] person = people[i]; // tallest first
            q.add(person[1], person); // place after num of people in front of them
        } // n^2
        return q.toArray(new int[0][]);
    }
}