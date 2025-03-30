// Time Complexity : O(n)
// Space Complexity : O(26)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }

        int st = 0;
        int ed = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            ed = Math.max(ed, map.get(c));
            if (i == ed) {
                res.add(ed - st + 1);
                st = ed + 1;
            }
        }
        return res;
    }
}