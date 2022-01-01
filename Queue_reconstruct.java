// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, ( a, b) -> {
            if(a[0] == b[0]){
                return a[1]-b[1];
            }
            return b[0]- a[0];
        });
        ArrayList<int[]> output = new ArrayList<>();
        
        for(int[] p: people)
            output.add(p[1],p);
        return output.toArray(new int[0][]);
       
    }
}