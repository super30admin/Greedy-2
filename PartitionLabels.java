class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();
        
        //base case
        if(S == null || S.length() == 0){
            return result;
        }
        
        //End indexes of each character
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < S.length(); i++){
            map.put(S.charAt(i), i);
        }
        
        int start = 0; int end = 0;
        
        for(int i = 0; i < S.length(); i++){
            //updating the end pointer everytime we encounter a new character
            end = Math.max(end, map.get(S.charAt(i)));
            
            //if i reaches end then. that is a valid parition
            //add size to result and set new start and end pointers
            if(end == i){
                result.add(end - start + 1);
                start = end + 1;
                end = start;
            }
        }
        
        return result;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)