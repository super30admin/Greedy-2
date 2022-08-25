// Time Complexity : O(n)
// Space Complexity : O(1) //map is max 26 chars
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public List<Integer> partitionLabels(String s) {

        ArrayList<Integer> result = new ArrayList();

        if(s.length() == 0)
            return result;

        //stores last index of each char
        HashMap<Character, Integer> map = new HashMap();

        for(int i=0; i<s.length(); i++)
            map.put(s.charAt(i), i);

        int start = 0;
        int end = 0;

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);

            //end will be current end or last occurence of current char
            end = Math.max(end, map.get(c));

            //i reaches end of partition
            if(i==end) {
                //add partition length to result list
                result.add(end - start + 1);
                //start next partition
                start = i+1;
            }
        }
        return result;
    }
}
