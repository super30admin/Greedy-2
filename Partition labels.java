// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
// We will follow a sliding window approach. We will add all the characters in the Hashmap and their values will be the index of their last occurence. 
// We will iterate through the given  string and look for the last index of the first character, that becomes a window. Then we will iterate through 
// the characters of the window and see if they lie in the range by referring the hashmap. 
// If they don't, then we increase the size of the window. If we have reached the end of the window, then we will add the index to the result array.

class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result=new ArrayList<>();
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            map.put(c,i); //add the index of the last occurence of the character
        }

        int start=0, end=0;
        for(int i=0;i<s.length();i++)
        {
            char c = s.charAt(i);
            //check if the character lies in the range of the window
            end=Math.max(map.get(c),end);
            if(i==end)
            {
                result.add(end-start+1);
                start=i+1;
            }
        }
       return result; 
    }
}