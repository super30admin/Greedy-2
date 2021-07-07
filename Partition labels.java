TC:O(n)
SC:O(1)

Runtime: 7 ms, faster than 22.86% of Java online submissions for Partition Labels.
Memory Usage: 36.3 MB, less than 96.10% of Java online submissions for Partition Labels.

Approach: First have a map which has key as character and value as latest index of the character. Traverse through the characters 
in the string and update the end variable as max of current end value and latest index of the current character. Once all the latest index
of all characters within the current end value, update start as end+1 and add the intervale end-start+1 to the returning list.


class Solution {
    public List<Integer> partitionLabels(String S) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0; i< S.length();i++){
            map.put(S.charAt(i),i); // to create last index hashmap
        }
    int start=0;
    int end = 0;
        
        List<Integer> list = new ArrayList<>();
        
        for(int i=0;i<S.length();i++){
            char ch = S.charAt(i);
            
            end = Math.max(end,map.get(ch));
            
            if(i== end || i== S.length()-1){
                list.add(end-start+1);
                 start = end+1;
            }
            
        }
        
        return list;
    
    }
    
}
