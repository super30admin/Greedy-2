// Time Complexity : O(n)
// Space Complexity : O(1) -> because HashMap holds max of 26 characters
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// 1: First we create a HashMap that holds the last occurence of each character in the string
// 2: Then during second iteration, we keep track of the last index of any characters seen. This becomes the new end pointer
// 3: Once we have iterated and reached the last index, we partition the string and add the length to our result
class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        // creating a HashMap with the last occurence of each character
        for(int i =0; i<s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch, i);
        }

        List<Integer> result = new ArrayList<>();
        int start=0, end=0;
        for(int i =0; i<s.length(); i++){
            char ch = s.charAt(i);
            // setting the end pointer to the index of last occurence
            end = Math.max(end, map.get(ch));
            if(i == end){
                result.add(end - start + 1);
                start = i+1;
            }
        }
        return result;
    }
}