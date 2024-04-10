//TimeComplexity: O(N)
//SpaceComplexity: O(N)

class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i =0; i<s.length();i++) {
            char ch = s.charAt(i);
            if(!map.containsKey(ch)) {
                map.put(ch,i);
            }
            map.put(ch,i);
        }
        int start = 0;
        int end = 0;
        for(int i =0 ;i<s.length();i++) {
            char ch = s.charAt(i);
            end = Math.max(end, map.get(ch));
            if(i == end) {
                result.add(end - start+1);
                start = end+1;

            }
        }
        return result;
    }
}