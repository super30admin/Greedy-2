//Time Complexity : O(n^2)
//Space Complexity: O(n)
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,(a,b) -> {
            if(a[0] == b[0]){
                return a[1] -b[1];
            }
            return b[0]-a[0];
        });
        List<int[]> q = new ArrayList<>();
        for(int[] person : people){
            q.add(person[1], person);
        }
        int[][] result = new int[people.length][2];
        for(int i=0; i< result.length; i++){
            result[i] = q.get(i);
        }
        return result;
    }
}
