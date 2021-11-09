// Time Complexity : O(N^2)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class queueReconstruction {
    public int[][] reconstructQueue(int[][] people) {
                
        List<int[]> result = new ArrayList <int[]> ();
        
        Arrays.sort(people, (a,b) -> {
            if(a[0] == b[0])
                return a[1] - b[1];
            return b[0] - a[0];
        });
        
        
        for(int[] p:people){
            result.add(p[1],p);
        }
        
        return result.toArray(new int[people.length][2]);
    }
}
