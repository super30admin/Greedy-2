/* Time Complexity : O(nlogn + n^2)
 *  n - length of array - people */
/* Space Complexity : O(n) */
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//Greedy

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        int n = people.length;
		
		//Sort DESC in terms of height and ASC in terms of other people in front who have a height greater than or equal to height 
        Arrays.sort(people, (a, b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            } else{
                return b[0] - a[0];
            }
        });

        List<int[]> q = new ArrayList<>();
        for(int[] person: people){
            q.add(person[1], person);
        }
        int[][] res = new int[n][2];
        for(int i = 0; i < n; i++){            
            res[i] = q.get(i);
        }
        return res;
    }
}