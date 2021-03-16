//Time Complexity: o(n)
//Space Complexity: o(n)
//Expln: Store the last index of each element in the hashmap. Iterate over the hashmap
// keep updating the end by max from the  hashmap for every Character, whenever the index from array 
// meets the end that means thats the last position for the occurence of the char. Store the value of last position
// update start to next char and do this till end of the string.
class Solution {
    public List<Integer> partitionLabels(String S) {
        Map<Character, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        if(S.length() == 0) return res;
        
        for(int i = 0; i < S.length(); i++)
        {
            char c = S.charAt(i);
            map.put(c, i);
        }
        
        int start = 0; int end = 0;
        for(int i = 0; i < S.length(); i++)
        {
            char ch = S.charAt(i);
            end = Math.max(end, map.get(ch));
            if(i == end)
            {
                res.add(end-start+1);
                start  = end+1;
            }
        }
        return res;
    }
}