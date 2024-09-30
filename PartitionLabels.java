// Time Complexity : O(2n) ~ O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Partitionlabels {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, i);
        }
        int start = 0, end = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            end = Math.max(end, map.get(c));
            if(i == end) {
                res.add(end-start+1);
                start = end+1;
            }
        }
        return res;
    }
}