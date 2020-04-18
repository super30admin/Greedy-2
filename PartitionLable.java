// Time Complexity : O(n) Length of the string
// Space Complexity : O(1) -> as the LastIndex array will have constant of 26 char its constant.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes


// Your code here along with comments explaining your approach
// Initialize WINDOW start and end to zero.
// Get the last occurance of all the char and store in the LAST INDEX array.
// Start by assigning the END of window with last occurance index of first char in string 
//        0123456789 
// In Eg  ababcbacadefegdehijhklij
// First char a's last occurance is 8. After assiging end to 8 Initial window will be from Start = 0 and end = 8
// Parse from 0 till 8 check if any char has MAXIMUM last index if so reset the end to MAXIMUM LAST INDEX
// In the above example there are no char has last index greater than 8 i.e b->5, c->7
// When the cursor reaches end calculate the window length, add to the list and move the start to end+1
// NOTE -- START is just to calculate the window.
class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<Integer>();
        
        if(s == null|| s.length() ==0)
            return result;
        
        int[] lastIndex = new int[26];
        
        
        int start=0, end = 0;
        for(int i=0; i<s.length(); i++){
            int index = s.charAt(i) - 'a';
            lastIndex[index] = i;
        }
        
        for(int i=0; i<s.length();i++){
            int index = s.charAt(i) - 'a';
            end = Math.max(end, lastIndex[index]);
            
            if(i ==end){
                result.add(end-start+1);
                start = end+1;
            }
        }
        return result;
    }
}
