// Time Complexity: O(n) where n is the length of the string.
// Space Complexity: O(1) since hashmap always has a maximum of 26 letters.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        if(s == null || s.length() == 0) return new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();      // {Letter, its last index}
        List<Integer> answer = new ArrayList<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, i);
        }
        int start = 0, end = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            end = Math.max(end, map.get(c));
            if(i == end) {
                answer.add(end - start + 1);
                start = end + 1;
            }
        }
        return answer;
    }
}