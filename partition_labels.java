// Time Complexity : O(n)
// Space Complexity :O(1)
class Solution {
    public List<Integer> partitionLabels(String s) {
        if(s==null || s.length()==0) return new ArrayList<>(){};
        List<Integer> res=new ArrayList<>();
        HashMap<Character,Integer> map=new HashMap<>();
        
        for(int i=0;i<s.length();i++){
            char c= s.charAt(i);
            map.put(c,i);
        }
        int start=0, end=0;
        
        for(int i=0;i<s.length();i++){
            char c= s.charAt(i);
            end= Math.max(end,map.get(c));
            
            if(i==end){
                res.add(end-start+1);
                start= i+1;
                
            }
            
        }
        return res;
    }
}