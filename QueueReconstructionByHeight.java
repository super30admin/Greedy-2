// Greedy
// TC: O(N^2)
// SC: O(N)
// Did it run sucessfully on Leetcode? : Yes
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if ( people == null || people.length == 0)
            return new int[][]{};
        List<int[]> q = new ArrayList();
        // sort people array in descending order of their heights. If heights are equal, sort them based on ascending order of the no. of people in front of them
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0])
            {
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });
        
     //  Input - [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
     //  After sorting people- [[7,0],[7,1],[6,1],[6,1],[5,0],[5,2]]
       for (int[] person : people)
       {
           q.add(person[1], person);
       }
    
    // convert List<int> into int[][] ( as the question requires)
       int[][] result = new int[people.length][2];
       for ( int i = 0; i < q.size(); i++)
       {
           result[i] = q.get(i);
       }
        return result;
    }
}
