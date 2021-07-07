//Tc : O(n) n is length of string
//SC : O(1)
class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();
        int[] map = new int[26];
        
        if(S == null || S.length() == 0)
            return result;
        
        for(int i=0;i<S.length();i++){
            char c = S.charAt(i);
            map[c-'a'] = i;
        }
        
        int start = 0,end = 0;
        
        for(int i=0;i<S.length();i++){
            char c = S.charAt(i);
            end = Math.max(end,map[c-'a']);
            
            if(end == i){
                result.add(end-start+1);
                start = end+1;
            }
        }
        
        return result;
        
    }
}