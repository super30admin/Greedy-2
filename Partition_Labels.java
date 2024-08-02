// Time Complexity : O(n)
// Space Complexity : O(1) // 26 characters
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        List<Integer> result = new LinkedList<>();
        int start = 0;
        int end = 0;
        for(int i = 0; i< s.length(); i++){
            char c = s.charAt(i);
            map.put(c,i);
        }
        for(int i = 0; i< s.length(); i++){
            char c = s.charAt(i);
            end = Math.max(end, map.get(c));
            if(i == end){
                result.add(end - start + 1);
                start = end + 1;
            }
        }
        return result;
    }
}