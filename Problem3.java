//763 partition labesl
// time - O(n)
// space - o(1)
class Solution {
    public List<Integer> partitionLabels(String s) {
        
        int end = 0;
        int start = 0;
        ArrayList<Integer> result = new ArrayList();
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            map.put(c, i);
        }
        
        for(int i = 0; i < s.length(); i++){
           char c = s.charAt(i); 
            
            if(map.get(c) > end){
                
                end = map.get(c);
            }
            
            if(i == end){
                
                result.add(end - start + 1);
                start = i + 1;
            }
        }
        
        return result;
    }
}