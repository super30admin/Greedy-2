// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        
        Arrays.sort(people, (int[] a, int[] b) -> {
            if(a[0] == b[0]) {
                return a[1] - b[1];
            }
            
            return b[0] - a[0];
        });
        
        
        List<int[]> result = new ArrayList<>();
        
        for(int[] person: people) {
            result.add(person[1], person);
        }
        
        return result.toArray(new int[0][]);
    }
}