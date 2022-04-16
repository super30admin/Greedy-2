// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Create a hashmap which would contain the last occurence index of each characters in the string
// Now loop through the string and keep a pointer to the max last position to each character.
// When current pointer reaches the last max position we can calculate the interval and add to answer
// Now we will reset the start pointer and continue to get our result.
class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> hm = new HashMap<>();
        int start = 0;
        int end = 0;
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            hm.put(s.charAt(i), i);
            
        }
        for(int i = 0; i < s.length(); i++){
            end = Math.max(end,hm.get(s.charAt(i)));
            if(end == i){
                res.add(end - start + 1);
                start = i+1;
            }
        }
        return res;
    }
}