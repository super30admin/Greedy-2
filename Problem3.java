// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


class Solution {
    public List<Integer> partitionLabels(String s) 
    {
        List<Integer> result = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length();i++)
        {
            char c = s.charAt(i);
            map.put(c,i);
        }
        int start = 0;
        int end = 0;
        for(int i=0;i<s.length();i++)
        {
            char c = s.charAt(i);
            end = Math.max(end,map.get(c));
            if(i==end)
            {
                result.add(end - start+1);
                start = i+1;
            }
        }
        return result;
    }
}