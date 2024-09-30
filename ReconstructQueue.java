// Time Complexity : O(nlogn) + O(n^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class ReconstructQueue {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a,b) -> {
        if(a[0] == b[0]) {
            return a[1] - b[1];
        }
        return b[0] - a[0];
        });
        List<int[]> res = new ArrayList<>();
        for(int[] p : people) {
            res.add(p[1],p);
        }
        return res.toArray(new int[0][]);
    }
}