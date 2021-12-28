//Time - O(N)
//Space - O(1) - constant for defined set of alphabets

class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> lastOccurance = new HashMap<>();
        int start = 0;
        int end = 0;
        List<Integer> result = new ArrayList<>();
        
        for(int i = 0; i < s.length(); i++){
            lastOccurance.put(s.charAt(i), i);
        }
        
        for(int i = 0; i < s.length(); i++){
            Character c = s.charAt(i);
            if(lastOccurance.get(c) > end){
                end = lastOccurance.get(c);
            }
            
            if(i == end){
                result.add(end - start + 1);
                start = end + 1;
            }
        }
        return result;
    }
}