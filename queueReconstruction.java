//Time - O(n^2) - For loop and there O(n) for inserting
//Space - O(1) - result is the required array

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            else
                return b[0] - a[0];
        });
        
        List<int []> result = new ArrayList<>();
        for(int i = 0; i < people.length; i++){
            result.add(people[i][1], people[i]);
        }
        
        return result.toArray(new int[people.length][2]);
    }
}