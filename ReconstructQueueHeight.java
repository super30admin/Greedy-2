// Time complexity :O(n^2)
// Space Complexity :O(n)
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a,b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        List <int []> result = new ArrayList<>();
        for(int [] p : people){
            result.add(p[1], p);
        }
        return result.toArray(new int [0][]);
    }
}