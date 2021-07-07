// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

//Time Complexity : O(nlogn) for sorting the Array and O(n) since we are iterating through the array linearily   
//Space Complexity: O(1) since we are not using any extra space
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });
        
        List<int []> lst = new ArrayList<>();
        for(int[] person : people){
            lst.add(person[1], person);
        }
        
        return lst.toArray(new int[0][]);
    }
}