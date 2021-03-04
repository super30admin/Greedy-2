// Time - O(N), Space - O(1)

class Solution {
    public List<Integer> partitionLabels(String s) {
        if(s == null || s.length() == 0) {
            return new ArrayList<>();
        }
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i=0; i< s.length(); i++) {
            char ch = s.charAt(i);            
            map.put(ch, i);
        }
        
        int start = 0, end = 0;
        
        List<Integer> result = new ArrayList<>();
        
        for(int i=0;i<s.length();i++) {
            char ch =s.charAt(i);
            
            end = Math.max(end, map.get(ch));
            if(i == end) {
                result.add(end - start + 1);
                start = i + 1;                
            }
                          
            
        }
        
        return result;
    }
}
