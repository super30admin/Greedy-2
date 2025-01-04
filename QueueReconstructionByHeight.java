// Approach : From the intution of Brute Force where we need to make permutations with every people in people array at different positions which will be n!
// Optimized Approach - Sort the people array based on their heights in desc order. If the people with same height then sort the people
// infront of this person with height greater or equal to in ascending order. Now try to reconstruct by simpling placing the people at the corresponding index.
// when placing we might need to move already existing elements to the right - which constitues n^2 time complexity.
// Time : O(nlogn) + O(n^2)
// Space : O(n)
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // sort people with heights - desc
        Arrays.sort(people,(a,b)->{
            if(a[0]==b[0]){
                return a[1]-b[1]; // asc - people
            }
            return b[0]-a[0]; // asc - height
        });
        List<int[]> result = new ArrayList<>();
        // reconstruct
        for(int[] p: people){
            result.add(p[1],p);
        }


        return result.toArray(new int[0][0]);
    }
}