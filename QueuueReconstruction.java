// Time Complexity- O(nlogn)
// Space complexity -O(1)
// solved on leetcode - yes
// faced any issues - No
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
