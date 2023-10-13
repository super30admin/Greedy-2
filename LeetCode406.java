// Time Complexity : O(n2) 
// Space Complexity : O(n) // list
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // sort based on height in desc. if same asc of no.of people allowed 
        //nlogn
        Arrays.sort(people,(a,b)->{
            if(a[0]==b[0])
                return a[1]-b[1];
            return b[0]-a[0];
        });
        List<int[]> list = new ArrayList<>();
        // restructuring take o(n2)
        for(int[] ppl : people){
            list.add(ppl[1],ppl);  // insert at its index
        }
        return list.toArray(new int[list.size()][]); 
    }
}