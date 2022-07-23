// Time Complexity :O(n)
// Space Complexity :constant
// Did this code successfully run on Leetcode :yes

class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        // store last indices for evry character
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, i);
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // stretch the window if within window we get last index more than end
            end = Math.max(end, map.get(ch));
            if (i == end) {// on reaching end , we found a partition and make start from next window
                result.add(end - start + 1);
                start = end + 1;
            }
        }
        return result;
    }
}