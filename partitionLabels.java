//APPROACH: We create a hashmap and store the last indices of each character. Then we again iterate over the array and set the end variable to max index value of each character from the map. This way we get the farthest index and while iterating i becomes equal to the end then we can safely say all the characters are lie to the left of the end and we add that end value in the result arraylist. We update the value of start again to end + 1 to get the length of new partition along the way.
//time complexity O(2n) => O(n) since we iterate twice
//space compexity O(1) => although we use hashmap but we dont consider its space because its constant and at max it will only have 26 characters in it.

class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();
        if(S == null || S.length() == 0) return result;
        HashMap<Character, Integer> map = new HashMap<>();
        int end = 0; int start = 0;
        for(int i = 0; i < S.length(); i++){
            char c = S.charAt(i);
            map.put(c, i);
        }
        for(int i = 0; i < S.length(); i++){
            char c  = S.charAt(i);
            end = Math.max(end, map.get(c));
            if(i == end){
                result.add(end - start + 1);
                start = end + 1;
            }
        }
        return result;
    }
}
