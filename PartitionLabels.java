// Time Complexity : O(2n)
// Space Complexity : O(26) ~= O(1)
// n is the length of given string s
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        //null check
        if(s == null || s.length() == 0)
            return result;

        HashMap<Character,Integer> map = new HashMap<>();
        int n = s.length();

        //put last occurence of character in map
        for(int k = 0 ; k < n ; k++){
            char c = s.charAt(k);
            map.put(c,k);
        }

        int start = 0;
        int end = 0;

        for(int i = 0 ; i < n ; i++){
            char c = s.charAt(i);
            end = Math.max(end ,map.get(c));
            if(i == end){
                result.add(end-start+1);
                start = end+1;
            }
        }
        return result;
    }
}
