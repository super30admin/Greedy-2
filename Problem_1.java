// Time complexity - O(n)
// Space complexity - O(n)

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a,b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            }else{
                return b[0] - a[0];
            }
        });
        
        List<int[]> result = new ArrayList<>();
        for(int[] person : people){
            result.add(person[1],person);
        }
        return result.toArray(new int[0][]);
    }
}
