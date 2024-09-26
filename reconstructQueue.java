// Time Complexity : O(n^2) where n is the length of the array people
// Space Complexity : O(n) where n is the length of the array people
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class reconstructQueue {
    public int[][] reconstructQueue(int[][] people) {
        if (people.length == 0) return new int[0][0];
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        List<int[]> ans = new ArrayList<>();
        for (int[] p : people) {
            ans.add(p[1], p);
        }
        return ans.toArray(new int[people.length][2]);
    }
}