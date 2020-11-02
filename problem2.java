class Solution {
    public List<Integer> partitionLabels(String s) {

        int last_indices[] = new int[26];

        for (int i = 0; i < s.length(); i++) {
            last_indices[s.charAt(i) - 'a'] = i;
        }
        int start = 0;
        int end = 0;

        List<Integer> ans = new ArrayList();

        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, last_indices[s.charAt(i) - 'a']);

            if (i == end) {
                ans.add(end - start + 1);
                start = end + 1;
            }

        }

        return ans;
    }
}