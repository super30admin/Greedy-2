// TC : O(n)
// SC : O(1)


class Solution {
    public List<Integer> partitionLabels(String s) {
        if (s == null || s.length() == 0)
            return new ArrayList<>();

        // record the last occurrence of each character in string
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, i);
        }
        List<Integer> result = new ArrayList<>();
        // form partitions
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            end = Math.max(end, map.get(c));
            if (i == end) {
                result.add(end - start + 1);
                start = end + 1;
            }
        }

        return result;

    }
}