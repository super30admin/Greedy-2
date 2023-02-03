//https://leetcode.com/problems/partition-labels
//TC : O(n)
//SC : O(n)  


class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0; i<s.length();i++){
            char c = s.charAt(i);
            map.put(c,i);
        }
        int start = 0, end=0;
        for(int i=0; i<s.length();i++){
            char c = s.charAt(i);
            end= Math.max(end,map.get(c));
            if(i==end){
                result.add(end - start + 1);
                start = i+1;
            }
        }
        return result;
    }
}
