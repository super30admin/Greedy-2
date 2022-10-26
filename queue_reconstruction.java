// Time Complexity : O(nxn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if(people==null || people.length==0) return new int[0][];

        Arrays.sort(people,(a,b)->{
            if(a[0]==b[0]){
                return a[1]-b[1];
            }
            else return b[0]-a[0];
        });
        List<int[]> li = new ArrayList<>();

        for(int[] person : people){
            li.add(person[1],person);
        }

        return li.toArray(new int[0][]);
    }
}