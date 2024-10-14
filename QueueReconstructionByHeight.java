// Time Complexity : O(nlogn) to sort + O(n*2) as insertion at particular index takes O(n) and we have total n elements
// Space Complexity : O(n) due to an additional list
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No.

/*
Approach: Started by sorting in descending order with respect to the height. If people have same height then sort in ascending order w.r.t to people of that person. Then imply iterate over the sorted array and then store the result in a list by inserting to a particular position which can be captured by every second element of an array. Finally convert the list to an array and return.
 */
class Solution {
    public int[][] reconstructQueue(int[][] people) {

        Arrays.sort(people, (a,b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            }

            return b[0] - a[0];
        });

        List<int[]> result = new ArrayList<>();

        for(int[] person: people){
            result.add(person[1], person);
        }

        return result.toArray(new int[][]{});
    }
}