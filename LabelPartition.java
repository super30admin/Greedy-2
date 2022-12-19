// Time Complexity :O(l)) - 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes


// Your code here along with comments explaining your approach
/*
 * 1 - Traverse over the entire string first and create a HashMap. The map will store the last index of each char
 * 2 - Take a char, place the end pointer at the last occurence of that char, incremenent the traversing pointer
 * and if it reaches the end pointer, calculate the length and add it to the result.
 */

public class LabelPartition {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        int start = 0;
        int end = 0;
        
        for(int i = 0; i < s.length();i++)
        {
            char c = s.charAt(i);
            map.put(c,i);
        }
        
        for(int i = 0; i<s.length();i++)
        {
            char c= s.charAt(i);
            end = Math.max(end,map.get(c));
            if(i == end)
            {
                result.add(end - start + 1);
                start = end + 1;
            }
        }
        return result;
    }
}
