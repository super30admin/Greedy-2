// Time Complexity : O(n^2)
// Space Complexity : O(n), arraylist
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : followed from class

// Your code here along with comments explaining your approach
// first sort by height in descending order, if heigts are equal arange people by #people allowed in front 
// place items in arraylist specifically at that index, given by item[1], on placing again arraylist moves current element to right

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a,b) -> a[0]==b[0] ? a[1] - b[1] : b[0] - a[0]);
        
        List<int[]> result = new ArrayList<>();
        
        for(int[] p : people){
            result.add(p[1], p);
        }
        
        return result.toArray(new int[0][]);
    }
}