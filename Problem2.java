// 406 Queue Reconstruction by Height
// time - O(n2)
// space - o(1)

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        
        
        Arrays.sort(people, (a, b) -> {
            
            if(a[0] == b[0]){
                
                return a[1] - b[1];
            }
            
            return b[0] - a[0];
        });
            
            
        ArrayList<int []> result = new ArrayList();
        
        for(int i = 0; i < people.length; i ++){
            
            int[] curr = people[i];
            result.add(curr[1], curr);
        }
        
        return result.toArray(new int[people.length][2]);
    }
}