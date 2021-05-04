
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        
        
        Arrays.sort(people, (a,b) -> {
            //sort the in ascending based on 2nd index if the heights are same 
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            // sort in descending order of heights of people
            else{
                return b[0] - a[0];
            }
        });
        
        //declare a result list
        List<int[]> result = new ArrayList<>();
        
        //place all the elements in people array based on their second index position
        for(int[] p : people){
            result.add(p[1], p);
        }
        
        //return the result in array format
        return result.toArray(new int[0][]);
    }
}
// Time Complexity: O(nlogn)
// Space Complexity:O(n)