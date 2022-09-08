// TC: O(n)
// SC: O(1) used hashmap but character 26 only cant go more so constant


class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        HashMap<Character,Integer> map = new HashMap<>(); // character and its last ocuurence
    
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);  
            map.put(c,i);          
        }
        
        int start=0;
        int end=0;
        
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            end=Math.max(end,map.get(c));
            if(i==end){
                result.add(end-start+1);
                start=end+1;
            }
        }
        
        return result;
    }
}
