// Time Complexity : O(n^2), where n is the number of rows in the 2D array
// Space Complexity : O(n), where n is the number of rows in the 2D array (arraylist space) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I faced to problems
                                            //1. Not sure if my space complexity is correct, as we are creating an arraylist to store
                                                    //the result, but we are not returning it as it, we are converting to 2D array first.
                                                    //so should it be O(n) only or O(1)??
                                            //2. I am not understanding, if how the conversion of Arraylist of arrays To Array of arrays
                                                    //is working ("result.toArray(new int[0][])"). why are we passing 0 to the row size
                                                    //and why the column size is empty??
                        
//Three liner explanation of your code in plain English
//Intuition -> As we are reconstructing the array, we want to start with a person who is independent of any other person. And that 
                //person would be the tallest person in the group who has no person in front of him with equal to or with greater
                //hieght and then arrange the rest of the people according to him
//1. As discussed, sort the array in descending order w.r.t the height (h) of the people in descending order and if 2 people have same 
                //height, then sort those people in ascending order w.r.t to the number of people in front on them (k).
//2. now the tallest people(s) are in the correct order, but there can be other shorter people inbetween them who do not make any
                //effect to them, but themselves get affected.
                //So again iterate over the above sorted array and the correct place of the shorter people is at the index equal to
                //the number of people in front of them, while shifting the taller people to right if any.
//3. In the end convert the resultant Arraylist of arrays To Array of arrays and return.
//P.S. We first use Arraylist of arrays to store the result, because if we are adding a person at an index and the index is already
                //taken , then we want to move the existing people to the right (We cannot do this using 2D array)


// Your code here along with comments explaining your approach

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        int m = people.length;
        int n = people[0].length;
        //result to return 
        // int[][] result = new result[m][n];
        List<int[]> result = new ArrayList<int[]>();
        //sort the people in descending order w.r.t to their hieght (h) and if 2 people have same height, sort them in ascending order w.r.t to the number of people in front of them (k)
        Arrays.sort(people, (a, b)->{
            //if two people have the same height
            if(a[0] == b[0]) return a[1]-b[1];
            //else sort them with their heights
            return b[0]-a[0];
        });
        
        //traverse over the above sorted array and place the person at the index equal to the number of people in front of them
        for(int[] person : people){
           result.add(person[1], person);
        }
        //convert arraylist of arrays To Array of arrays
        return result.toArray(new int[0][]);
    }
}