// Time Complexity : O(n)
// Space Complexity : O(1)

/*
 * get the last index of each element and make a hashmap of it.
 * iterate though the array and if the current index is last value of character
 * add the range to result and mark start as index +1
 */

class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        if(s == null || s.length() == 0) return result;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            map.put(c, i);
        }

        int start = 0; int end = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            end = Math.max(end, map.get(c));
            if(i == end){
                result.add(end-start+1);
                start = i+1;
            }
        }
        return result;
    }
}