//TC : O(N) - Traversing string in linea time for calculating partitions
//SC : O(1) //Map use constant space and res list is O/P data structure        
class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        
        if(s == null || s.length() == 0)  return res;
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i< s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch, i);
        }
        
        int start = 0, end = 0;
        
        for(int i = 0; i< s.length(); i++){
            char ch = s.charAt(i);
            end = Math.max(end, map.get(ch));
            if(i == end){
                res.add(end - start + 1);
                start = i + 1; 
            }
        }
        
        
        return res;
    }
}