class Solution {
    public List<Integer> partitionLabels(String s) {

        List<Integer> result = new LinkedList<>();

        int[] last = new int[26];

        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        int st = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            end = Math.max(end, last[c - 'a']);

            if (i == end) {
                result.add(end - st + 1);
                st = i + 1;
                end = i + 1;
            }
        }

        return result;
    }
}