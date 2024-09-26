// Time Complexity : O(n) where n is the length of the string S
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class partitionLabels {
    public List<Integer> partitionLabels(String S) {
        List<Integer> ans = new ArrayList<>();
        if (S == null || S.length() == 0) return ans;
        int[] lastIndex = new int[26];
        for (int i = 0; i < S.length(); i++) {
            lastIndex[S.charAt(i) - 'a'] = i;
        }
        int start = 0, end = 0;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            end = Math.max(end, lastIndex[c - 'a']);
            if (end == i) {
                ans.add(end - start + 1);
                start = end + 1;
            }
        }
        return ans;
    }
}