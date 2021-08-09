// Time Complexity : O(n)
// Space Complexity : O(1)

class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        if(s == null || s.length() == 0)
            return res;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            map.put(c, i);
        }
        
        int start = 0;
        int end = map.get(s.charAt(0));
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            end = Math.max(end, map.get(c));
            if(i >= end){
                res.add(end - start + 1);
                start = end + 1;
            }
        }
        
        return res;
    }
}