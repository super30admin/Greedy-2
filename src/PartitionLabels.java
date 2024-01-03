// Time Complexity:  O(n)
// Space Complexity: O(n)

class Solution {

    public List<Integer> partitionLabels(String s) {

        Map<Character, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        int start = 0;
        int end = 0;

        for(int i=0; i<s.length(); i++) {
            map.put(s.charAt(i), i);
        }

        for(int i=0; i<s.length(); i++) {
            end = Math.max(end, map.get(s.charAt(i)));
            if(i == end) {
                result.add(end-start+1);
                start=end+1;
            }
        }

        return result;

    }

}
