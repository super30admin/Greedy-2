// Time Complexity : O(2n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Take a hashmap and store last occurance of the char as value and the char as the key to take the
// window upto last occurance of char. When i reaches end position of the winfow, it means we can start a new window and repeat steps again
class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        if(S == null || S.length() == 0) return res;
        int start = 0, end = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<S.length();i++) {
            map.put(S.charAt(i),i);
        }
        for(int i=0;i<S.length();i++) {
            end = Math.max(end,map.get(S.charAt(i))); // store max ending index
            if(end == S.length()-1) { // char is at last position
                res.add(end-start+1); // add length to result list
                break;
            }
            if(i == end) { // reached end of window
                res.add(end-start+1); // add length to the result list
                start = end+1;
            }
        }
        return res;
    }
}