// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// Sort by h descending order
// then locate base in the index that is the k(people in front)
class Solution {
    public int[][] reconstructQueue(int[][] people) {
       
        
        if(people == null || people.length==0)
            return new int[0][];
        
        Arrays.sort(people, (a,b) -> a[0]==b[0] ? a[1]-b[1] : b[0] -a[0]);
        
        List<int[]> res = new ArrayList<>();
        for(int[] p : people){
            res.add(p[1], p);
        }
        return res.toArray(new int[0][]);  
    }
}
