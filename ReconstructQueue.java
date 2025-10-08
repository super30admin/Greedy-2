class Solution {
    //First, we sort the people by height in descending order, and if heights match then
    //sort by positions in ascending order
    //Next insert each person at the index equal to how many taller or equal people should be in 
    //front of them
    //Since taller people are already placed, inserting at that index ensures everyone sees the
    //same exact number of taller or equal people they expected
    //Time Complexity: O(n^2)
    //Space Complexity: O(n)
    public int[][] reconstructQueue(int[][] people) {
      List<int[]> result = new ArrayList();
      Arrays.sort(people,(a,b)->{return (a[0]==b[0]?a[1]-b[1]:b[0]-a[0]); });
      for(int[] x:people)
      {
         result.add(x[1],x);
      }
      return result.toArray(new int[people.length][2]);
    }
}