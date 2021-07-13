//Time Complexity : O(nlogn)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode :yes
//Any problem you faced while coding this : no
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        
        Arrays.sort(people, (a,b) -> {
          if(a[0] == b[0]){
            
            return a[1] - b[1];
          }  
            else{
                return b[0] - a[0];
            }
        });
        
        List<int[]> arr = new ArrayList<>();
        
        for(int[] person:people){
            
            //arr.add(i,people[0][i]);
            arr.add(person[1], person);
        }
        
    //    int[][] result = new int[arr.size()][2];
        
     /*   for(int i = 0; i < result.length; i ++){
            
            result[i][0] = arr.get(i)[0];
            result[i][1] = arr.get(i)[1];
        } */
        
        return arr.toArray(new int[arr.size()][2]);
    }
}