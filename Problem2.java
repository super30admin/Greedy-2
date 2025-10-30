/*
406. Queue Reconstruction by Height
Ran on leetcode: Yes
TC: O(n^2)
SC: O(n)
Sort the people in decending order of height and if the height is same ascending order of number of people. Place the people with heighest height first and then place the other people with lower height, since we placed the bigger height people first we dont have to change the relative position of them when we add the lower height people.
*/
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        
        Arrays.sort(people, (a, b) -> {
            if(a[0] == b[0]) { // If same height
                return a[1] - b[1]; // sort in ascending order of number of people can be in front of them
            }
            // sort in decending order of heights
            return b[0] - a[0];
        });

        List<int[]> result = new ArrayList<>();

        for(int[] peep: people){
            result.add(peep[1], peep);
        }

        return result.toArray(new int[0][0]);
    }
}