//TC - O(n)
//SC - O(1) - 26 chars in map
class Solution {
    public List<Integer> partitionLabels(String s) {
        if(s == null || s.length() == 0){
            return new ArrayList<>();
        }
        HashMap<Character,Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        int start = 0; 
        int end = 0;

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            map.put(c,i);
            
        }
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            end = Math.max(end,map.get(ch));
            if(i == end){
                res.add(end - start + 1);
                start = end + 1;
            }
        }
       return res; 
    }
}