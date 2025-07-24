// TC: O(n)
// SC: O(1)
class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        HashMap<Character, Integer> lastpos = new HashMap<>();
        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            lastpos.put(ch, i);
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            end = Math.max(end, lastpos.get(ch));
            if (i == end) {
                result.add(end - start + 1);
                start = i + 1;
            }
        }
        return result;
    }
}