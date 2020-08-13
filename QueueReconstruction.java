/**
 * Questn: pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h
 * Ex: Input:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 *
 * Output:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 *
 *
 * Algo: # Sort the array based on the heights (decreasing order) and if the heights are same sort it based on the ascending order of their ppl of greater heights visible to them
 *        [[7,0], [7,1], [6,1], [5,0], [5,2], [4,4]]
 *       # traverse thr each ele and place the ele based on their ele[1] value in the list ex: [7,0] ll be placed in 0th position abd [7,1] in 1st position and [6,1] in 1st pos which ll shift the other ele by 1
 *       [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 *
 *       Time: O(n^2) as adding the values at fixed location req n and traversing the gvn array takes n
 */
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,(a,b)->{                            //nlogn
            if(a[0] == b[0]) return a[1]-b[1];
            return b[0]-a[0]; });

        List<int[]> res = new ArrayList<>();

        for(int i=0;i<people.length;i++){                   //n
            res.add(people[i][1],people[i]);                  //n
        }
        return res.toArray(new int[res.size()][2]);
    }
}