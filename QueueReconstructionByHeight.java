// Time Complexity : O(n log n + n^2) = O(n^2)
// Space Complexity : O(1)
// n is the length of given string s
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(people, (a,b) -> {
            if(a[0] == b[0]){
                return a[1] -b[1];
            }
            return b[0] - a[0];
        });

        for(int[] person : people){
            result.add(person[1],person);
        }

        int[][] arr = new int[people.length][2];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = result.get(i);
        }
        return arr;

    }
}