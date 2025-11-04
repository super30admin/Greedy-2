/*
* Approach: Greedy approach
- Idea is to think about relative positions and think of people with the tallest height
- Sort people array by heights first and then by number of people in the front. 
- Iterate through the sorted array (consider example 1)
    - first person will be of height tallest and least number of people in the front so go ahead and add them to the list (7,0)
    - second person is either of height smaller or the same height but number of people will either be same/diff for diff height or different for same height (7,1), go ahead and add it to the list
    - similary third is (6,1) -> so height 6 can have one person of height greater or equal to 6 in front of it so go ahead and slide person of height (7,1) 
- TC: O(n^2logn) -> nlogn for sorting the people array and n^2 for sliding of people in the front
- SC: O(n)
 */
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        List<int[]> q = new ArrayList<>();
        Arrays.sort(people, (a,b) ->{ //nlogn
            if(a[0] == b[0]){ 
                return a[1] - b[1];
            } 
            return b[0] - a[0];
        });

        for(int[] per: people){//n^2 - sliding of people in front that is costly
            q.add(per[1], per);
        }
        
        return q.toArray(new int[0][]);
    }
}