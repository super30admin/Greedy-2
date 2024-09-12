// Time Complexity : O(n*n)
// Space Complexity : 0(1) we use list only for result, not considered in Space complexity
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Your code here along with comments explaining your approach


class Solution {
    public int[][] reconstructQueue(int[][] people) {
        //edgecase 
        if(people.length ==0 || people == null) return new int[0][0];
        // sort with a operate such that (a,b) both heights a,b are same sort by no. of ppl in asc 
        // else sort with height in desc
        Arrays.sort(people, (a,b) -> a[0] == b[0] ? a[1] - b[1]: b[0] - a[0]);
        
        List<int []> result = new ArrayList<>(); // list of int[] -> [],[],[]
        for(int [] person : people) {
            result.add(person[1],person); //arrange in the resultant list
        }
        return result.toArray(new int[0][]); // list to Array 
    }
}

//Next try this Sol. with P.Queue 

