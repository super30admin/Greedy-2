// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution {
    public List<Integer> partitionLabels(String s) {

        if(s== null || s.length() ==0) return new ArrayList<>();

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i=0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c,i);
        }

        int start = 0, end = 0;
        List<Integer> result = new ArrayList<>();

        for (int i=0; i < s.length(); i++) {
            char c = s.charAt(i);
            end = Math.max(end, map.get(c));
            if (i==end) {
                result.add(end - start + 1);
                start = end + 1;
            }
        }

        return result;
    }
}