package QueueReconstructionByHeight;

// Time Complexity : O(n log(n) + n^2) -> O(n^2)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        
        //O(n log(n))
        Arrays.sort(people, (a,b) -> {
            if(a[0] == b[0])
                return a[1]-b[1];
            return b[0]-a[0];
        });
        
        List<int[]> result = new ArrayList<>();
        //O(n^2)
        for(int[] el: people) {
            result.add(el[1], el);
        }
        
        return result.toArray(new int[0][]);            
    }
}