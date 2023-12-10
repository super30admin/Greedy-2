// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch,i);
        }
        int start = 0, end = 0;
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            end = Math.max(end,map.get(ch));
            if(i == end){
                res.add(end - start + 1);
                start = i + 1;
            }
        }
        return res;
    }
}