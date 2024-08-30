//TC: O(n)
//SC: O(1)

class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> partitions = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0 ; i<s.length() ; i++) {
            char c = s.charAt(i);
            map.put(c, i);
        }
        int start = 0;
        int end = 0;
        for(int i=0 ; i<s.length() ; i++) {
            char c = s.charAt(i);
            end = Math.max(end, map.get(c));
            if(i == end) {
                partitions.add(end - start + 1);
                start = i+1;
            }
        }
        return partitions;
    }
}