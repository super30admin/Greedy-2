//TC : O(n logn + n2) -> Asymptotic O(n2) 
//SC : O(1)
class Solution {
    public int[][] reconstructQueue(int[][] people) {
       
        List<int[]> result = new ArrayList<>();
        
        if(people == null || people.length == 0)
            return new int[0][0];
        
        Arrays.sort(people,(a,b)-> a[0]!=b[0]? b[0] - a[0] : a[1]-b[1]);
        
        for(int[] person : people){
            result.add(person[1],person);
        }
        
        return result.toArray(new int[0][]);
        
    }
}