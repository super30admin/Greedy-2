//Time Complexity : O(n)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode :yes
//Any problem you faced while coding this : no
class Solution {
    public List<Integer> partitionLabels(String s) {
        
        HashMap<Character,Integer> map1 = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        
        for(int i = 0; i < s.length(); i ++){
            
            char ch  = s.charAt(i);
            map1.put(ch, i);
        }
        
        int end = -1;
        int start = 0;
        //System.out.print(map1);
        for(int i = 0; i < s.length(); i ++){
            
            char ch  = s.charAt(i);
             if( map1.get(ch) > end){
                
                end = map1.get(ch);
            }
            //map1.put(ch, i);
            if(i == end){
                
                result.add((end - start)+1);
                start = i + 1;
            }
            
            
        }
        
        return result;
    }
}