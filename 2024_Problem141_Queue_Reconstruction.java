//406. Queue Reconstruction by Height - https://leetcode.com/problems/queue-reconstruction-by-height/description/
//Time Complexity: O(n log (n) + n^2) ~ initially sorting the queue based on height + adding the
                    //elements in between according to the number of people ahead
                    //which makes next elements move 1 step next in ArrayList
//Space Complexity: O(n)

//Greedy Optimal
//Approach: Sort in descending -> Fix the taller people first, then add smaller people in between as they will be
//insignificant to taller people

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        //sort array in decreasing order of height
        //[[7,0]] -> [height, no. of people before having >= height]
        Arrays.sort(people, (a,b) -> {
            //if same height, sort by no. of people ahead
            if(b[0] == a[0]){
                return a[1] - b[1]; //ascending order
            }
            return b[0] - a[0]; //descending order
        });

        List<int[]> result = new ArrayList<>();
        //go over all people, based on no. of people before, re-arrange again
        for(int[]p : people){
            result.add(p[1], p);
        }

        return result.toArray(new int[0][0]);
    }
}