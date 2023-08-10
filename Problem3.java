// Time: O(n)
// Space: O(1) since hashmap of 26 characters only every time



class Solution{
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList();
        if (s == null || s.length() == 0) return result;

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i<s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch,i);
        }

        int start = 0, end = map.get(s.charAt(0));
        for (int i = 0; i<s.length(); i++) {
            char ch = s.charAt(i);
            end = Math.max(end, map.get(ch));

            if (i == end) {
                result.add(end - start + 1);
                start = i + 1;
            }
        }
        return result;
    }
}