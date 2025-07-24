// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach : sort input based on heights (descending), if same based on k(ascending). Now for each entry, try to add it
/// to result based on it's k value, pushing all elements from its current position to right. Repeat until we reach end
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(people, (a,b) ->{
            if(a[0]==b[0]){
                return a[1]-b[1];
            }
            return b[0]-a[0];
        });
        for(int i=0;i<people.length;i++){
            res.add(people[i][1], people[i]);
        }
        int[][] result = new int[people.length][2];
        for(int i=0;i<res.size();i++){
            result[i] = res.get(i);
        }
        return result;
    }
}