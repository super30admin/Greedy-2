class Solution {
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public List<Integer> partitionLabels(String S) {
        
        if(S == null || S.length() == 0)
            return new ArrayList<>();
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        char ch;
        for(int i = 0; i < S.length(); i++){
            ch = S.charAt(i);
            map.put(ch, i);     // putting farthest index of each letter
        }
        
        List<Integer> output = new ArrayList<>();
        int start = 0, end = 0;
        
        for(int i = 0; i < S.length(); i++){
            if(end < map.get(S.charAt(i))){
               end = map.get(S.charAt(i));
            }
            
            if(i == end){
                output.add(end - start + 1);
                start = i + 1;
            }
        }
        return output;
    }
}