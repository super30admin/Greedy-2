//Time Complexity - O(n)
//Space Complexity - O(1)
class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, i);
        }

        int lStart = 0;
        int start = 0;
        int end = 0;

        List<Integer> result = new ArrayList<>();

        for(int i=0; i<s.length(); i++) {
            char curr = s.charAt(i);
            end = Math.max(end, map.get(curr));
            if (i == end) {
                result.add(end - start + 1);
                start = end + 1;
            }
        }
        return result;
    }
}
