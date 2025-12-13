// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Approach : We capture the last index occurence of each character of the string in a HashMap. We start iterating the string and capture the farthest occuring
// index of each character. When we reach that index, it means that one partition is done. We add the length of this partition to the result and update the
// start pointer and continue parsing with the logic.


class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            map.put(chars[i], i); //capture the last index of each character
        }
        List<Integer> result = new ArrayList<>();
        int start = 0;
        int end = 0;
        for (int i = 0; i < chars.length; i++) {
            end = Math.max(end, map.get(chars[i])); //farthest index of the character
            if (i == end) { //implies end of current partition
                result.add(end - start + 1); //add the length of current partition to the result
                start = end + 1; //update the start to next partition's starting point
            }
        }

        return result;
    }
}