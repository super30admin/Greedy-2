// Time Complexity : O(N) iterating all the elements one at a time
// Space Complexity : O(1), extra array used but it is constant (26)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : After class solution


// Your code here along with comments explaining your approach
//Store the last index of each character in an array.
//Then use two pointers (start and end) to iterate. Find the first element with highest last index and update end pointer.
//Whenever, end equals to the current index, store the result in return list and update the start.

class Solution {
   
    public List<Integer> partitionLabels(String S) {
       
        List<Integer> solution = new LinkedList<>();
        if(S == null || S.length() == 0) return solution;
        
        int[] lastIndex = new int[26];
        
        int n = S.length();
        
        //capture the last index of every character
        for(int i=0; i<n; i++){
            lastIndex[S.charAt(i) - 'a'] = i;
        }
        
        int start = 0, end = 0;
        
        for(int cursor=0; cursor<n; cursor++){
           
            char ch = S.charAt(cursor);
            
            //update the end to find the first element which has the highest last index
            end = Math.max(end, lastIndex[ch - 'a']);
            
            //whenever a match is hit with the last index and the cursor, this means that all the characters before that lies within the end boundary
            if(cursor == end){
                solution.add(end - start + 1);
                start = end + 1;//update the start
            }
            
        }
        
        return solution;
    }
}
