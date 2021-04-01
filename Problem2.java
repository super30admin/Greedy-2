// Time Complexity :O(n^2)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        ArrayList<int[]> output = new ArrayList<>();
        Arrays.sort(people, (a,b)->{//custome sort based on heights first and if height same then sort ascending manner
            if(a[0]==b[0])
                return a[1]-b[1];
            return b[0]-a[0];
            });
            
            for(int[] p : people){//add to list based on number of people forward as index
                output.add(p[1],p);
            }
        
        return (output.toArray(new int[0][]));
    }
}