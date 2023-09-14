// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
// We will sort the array according to its height i.e the value in index 0. If they are the same, then we will sort them according to the number of 
// people infont of them i.e value at index 1. We will iterate through this array and add the inner arrays in the list. When we add them in the list we 
// will place them in the index equal to the number of people infront of them for the respective array, i.e the value at index 1 for that array. Sorting the array in the beginning ensures that all the value in the beginning 
// will be greater than or equal to the new values which are being iterated. 

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a,b)->
        {
            if(a[0]==b[0]){return a[1]- b[1];}
            return b[0]-a[0];
        });

        List<int[]> q=new ArrayList<>();
        for(int[] person: people)
        {
            q.add(person[1],person);
        }

        int[][] result=new int[people.length][2];
        for(int i=0;i<people.length;i++)
        {
            result[i]=q.get(i);
        }

        return result;
    }
}