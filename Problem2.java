// Time Complexity : O(nlogn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,(a,b) -> {
            if(a[0] == b[0])
                return a[1] - b[1];
            return b[0] - a[0];
        });
        List<int[]> q = new ArrayList<>();
        for(int[] peepz : people){
            q.add(peepz[1], peepz);
        }
        int[][] res = new int[q.size()][2];
        for(int i = 0; i < res.length; i++)
            res[i] = q.get(i);
        return res;
    }
}
