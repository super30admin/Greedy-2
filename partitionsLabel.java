// Time Complexity: O(n)
// Space: O(1)
// Idea here is to greedilystore each character's farthest existence and
// while traversing through string checking if other characters fall under this window only
// if others are extending the end is extended as well
class Solution {
    public List<Integer> partitionLabels(String s) {
        if(s==null || s.length()==0) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i< s.length(); i++) {
            map.put(s.charAt(i), i);
        }
        
        int start = 0; int end = 0;
        for(int i = 0; i< s.length(); i++) {
            char c = s.charAt(i);
            end = Math.max(end, map.get(c));
            if(i==end) {
                res.add(i-start+1);
                start = i+1;
            }
        }
        return res;
    }
}