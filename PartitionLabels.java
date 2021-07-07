/**
LeetCode Submitted : YES
Space Complexity : O(1)
Time Complexity : O(length of String)

The idea is to use Map to store the character and last index of that character occuring in the string. Now take two pointers start/end and find max possible window till out iterator reaches end of the window where end is updated based on Maximum possible of the character in that partition. Once, out iterator reaches end of the window add it to result and return the final result after all characters in Strings are iterated.
**/
class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();
        if(S == null || S.length() < 1)
            return result;
        
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0; i< S.length();i++){
            char c = S.charAt(i);
            map.put(c,i);
        }
        
        int start = 0;
        int end = 0;
        for(int i = 0; i<S.length();i++){
            char c = S.charAt(i);
            end = Math.max(end,map.get(c));
            if(end == i){
                result.add(end-start + 1);
                start = end + 1;
            }
        }
        return result;
    }
}
