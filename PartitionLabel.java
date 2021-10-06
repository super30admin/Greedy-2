/*
Time: O(n) traverse complete array/string  
Space: O(1) constant 26 chars max
*/
class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        //Base:
        if(s==null || s.length() ==0) return result;
        //Logic:
        //Algorithm: Traverse the string and capture last occurrences of each char
        //Traverse once again and check the new chars(if any) and update the lengths
        // int l = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i< s.length(); i++){
            // System.out.println("char: "+s.charAt(i));
            char c = s.charAt(i);
            // if(!map.containsKey(c)){
                map.put(c, i);
            // }
        }
        
        int start = 0, end = 0;
        for(int i=0; i< s.length(); i++){
            char c = s.charAt(i);
            end = Math.max(end, map.get(c)); //charAt(c));
            if(end == i){
                result.add(end - start + 1);
                start = end + 1;
            }
        }
        return result;
    }
}
