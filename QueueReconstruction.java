// Time Complexity : O(n*2) - insertion in List takes O(n) for each operation. total is n*2
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Approach : We sort the input people array based on decreasing order of heights and if heights are equal, smallestk comes first. Now we insert the array at kth
// index that means exactly k people are ahead from that point. As the array was already sorted doing this will give the result.

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a,b)->{
            if(a[0] == b[0]){ //if heights are equal, consider smaller k first
                return a[1] - b[1];
            }
            return b[0] - a[0]; //decreasing order of heights
        });

        List<int[]> result = new ArrayList<>();

        for(int[] p : people){
            result.add(p[1], p); //add at index k
        }

        return result.toArray(new int[0][0]);
    }
}
