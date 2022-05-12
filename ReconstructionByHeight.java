//TC : O(N^2)
//SC : O(N)

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        List<int[]> li = new ArrayList<>();
        
        Arrays.sort(people, (a,b) -> { // If height is same, compare no. of people otherwiese comapare height
            if(a[0] == b[0])    return a[1] - b[1];
            return b[0] - a[0];
        });
        
        for(int[] p : people){
            li.add(p[1], p);
        }
        
        
        return li.toArray(people);
    }
}