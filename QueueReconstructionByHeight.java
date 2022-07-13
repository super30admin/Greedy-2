// Time Complexity : O(N^2)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        //sorting as per height in desc then by number of people allowed in front of him in asc
        Arrays.sort(people, (a, b) -> {
            if(a[0] == b[0])
                return a[1]-b[1];
            return b[0]-a[0];
        });
        List<int[]> res = new ArrayList<>();
        for(int[] p: people) {
            // putting the value according to freq
            // the array gets rearranged in every push
            res.add(p[1], p);
        }
        int[][] resultantArr = new int[res.size()][2];
        for(int i=0;i<res.size();i++) {
            resultantArr[i] = res.get(i);
        }
        return resultantArr;
    }
}