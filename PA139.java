//Leetcode : 406. Queue Reconstruction by Height
//Time Complexity:O(n^2) // sorting : O(nlogn) and for putting elements in the list at correct position it is O(n^2)
//Space Complexity: O(n) // used a list of size n while result array is an auxillary space.
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a,b)->(a[0]==b[0]?(a[1]-b[1]):(b[0]-a[0])));
        List<int[]> arr = new ArrayList<>();
         for(int[] p : people){
            arr.add(p[1],p);
        }
      return arr.toArray(new int[people.length][]);
    }
}