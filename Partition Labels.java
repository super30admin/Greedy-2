class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> lastIndexMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            lastIndexMap.put(s.charAt(i), i);
        }
        List<Integer> parts = new ArrayList<>();
        int size = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            size++;
            end = Math.max(end, lastIndexMap.get(s.charAt(i)));
            if (i == end) {
                parts.add(size);
                size = 0;
            }
        }
        return parts;
    }
}