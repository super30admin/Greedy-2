/*
763. Partition Labels
Ran on leetcode: Yes
TC: O(n)
SC: O(1)
Store the last index of each character in string, loop through the partion and update the end boundry if it is further. if we reach the end boundry save the partion size and find the next partion
*/
class Solution {
    public List<Integer> partitionLabels(String s) {

        List<Integer> result = new ArrayList<>();

        // Store the last index of each character in string
        Map<Character, Integer> endIdxMap = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            endIdxMap.put(s.charAt(i), i);
        }
        
        int start = 0;
        int end = 0;
        for(int i = 0; i < s.length(); i++){
            char currChar = s.charAt(i);
            end = Math.max(end, endIdxMap.get(currChar)); // update the end boundry
            if(end == i){ // if we reach the end boundry
                result.add(end - start + 1); // store the size of the partion in the list
                start = i + 1; // update hte start
            }
        }

        return result;
    }
}