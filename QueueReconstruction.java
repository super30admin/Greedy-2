// Time Complexity : O(n^2 + nlogn)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : yes

//Approach: My height doesn't get affected if short person stands in front or back. so greedily assign the tall people first and then
// adjust height accordingyly


// Your code here along with comments explaining your approach

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        int n = people.length;
        //TC: nlogn
        Arrays.sort(people, (a,b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1]; //increasing order of the num of people in front
            }

            return b[0] - a[0]; //decreasing order of the height
        });

        List<int[]> q = new ArrayList<>(); //SC: n
        //TC: n^2
        for(int[] person : people){
            q.add(person[1],person); // insert at index based on num of people in front
        }

        int[][] result = new int[n][2];
        for(int i = 0 ; i < n ; i++){
            result[i] = q.get(i);
        }

        return result;
    }
}