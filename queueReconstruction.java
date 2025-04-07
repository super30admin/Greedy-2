// Problem2 Queue Reconstruction by Height (https://leetcode.com/problems/queue-reconstruction-by-height/)

// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, sort array in such a manner that heights are in descending order and number of persons a front in ascending order. Now add them to
 * result at position of no.of persons at front index and finally return list converted into array. 
 */
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        List<int []> result = new ArrayList<>();
        Arrays.sort(people, (a,b)->{
            if(a[0] == b[0]){
                return a[1]-b[1]; //nlogn
            }
            return b[0]-a[0];
        });
        for(int [] person: people){ //n
            result.add(person[1], person); //n
        }
        return result.toArray(new int[0][]);
    }
}