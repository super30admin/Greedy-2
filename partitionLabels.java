// Time Complexity : O(N)
// Space Complexity : O(1) , atmost 26 character in HashMap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA


// Your code here along with comments explaining your approach

// Create a HashMap with character as key and its last index in string as val
// As we iterate through the length of string, update end variable value with map.get of character
// if current index reaches end value, update start to end + 1 and update result array with length end - start + 1


class Solution {
    public List<Integer> partitionLabels(String S) {

        if(S == null || S.length() == 0) return new ArrayList<>();

        List<Integer> result = new ArrayList<>();

        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            map.put(c, i);
        }

        int start = 0, end = 0;

        for(int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            end = Math.max(end, map.get(c));
            if(i == end) {
                result.add(end - start + 1);
                start = end + 1;
            }
        }

        return result;
    }
} 
