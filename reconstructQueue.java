// Time Complexity : O(n*n)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

// Your code here along with comments explaining your approach
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        
        Arrays.sort(people, new Comparator<int[]>() {
          @Override
          public int compare(int[] o1, int[] o2) {
            // if the heights are equal, compare k-values
            return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
          }
        });
        
                
        List<int[]> result=new ArrayList<int[]>();
        
        for(int[] p:people){
            result.add(p[1],p);
        }
        
        return result.toArray(new int[people.length][2]);
        
    }
}
