// SC is O(1) sice only lowe case chars . max length = 26. 
// TC =  O(n)
class Solution {
    public List<Integer> partitionLabels(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }

        int start = 0;
        int max = -1;
        List<Integer> result = new ArrayList<>();

        Map<Character, Integer> map = new HashMap<>();
        // put last occurrence of every char
        for (int i = 0; i < s.length(); ++i) {
            map.put(s.charAt(i), i);
        }

        for (int i = 0; i < s.length(); ++i) {
            if (map.get(s.charAt(i)) > max) {
                max = map.get(s.charAt(i));
            }

            if (i == max) {
                result.add(i - start + 1);
                start = i + 1;
                max = -1;
            }
        }

        return result;

    }
}