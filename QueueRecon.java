// Time Complexity :O(n^2) - time taken to traverse over the entire list plus shuffling time
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes


// Your code here along with comments explaining your approach
/*
 * 1 - Sort the array in descending order of heights and ascending order of people in front using a custom comparator.
 * 2 - Iterate over the array and place the array at index depending on the number of people required to be in front
 * 3 - Convert the Array List to the a 2-dimensional array
 */

public class QueueRecon {
    public int[][] reconstructQueue(int[][] people) {
        if(people == null || people.length == 0)
            return new int[0][0];
        
        Arrays.sort(people,
                   (a,b) -> {
                       if(a[0] == b[0])
                           return a[1] - b[1];
                       else
                           return b[0] - a[0];
                   });
        List<int[]> result = new ArrayList<>();
        
        for(int[] person:people)
        {
            result.add(person[1],person);
        }
        
        int[][] arr = new int[result.size()][2];
        for(int i = 0; i < arr.length;i++)
        {
            arr[i] = result.get(i);
        }
        return arr;
    }
}
