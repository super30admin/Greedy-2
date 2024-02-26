/* Time Complexity : O(2n) ~ O(n)
 *  n - length of string - s */
/* Space Complexity : O(26) ~ O(1) */
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//Greedy

class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();
        //get the last idx of a char in a map
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            map.put(c, i);
        }
        int start = 0;
        int end = 0;
        //iterate over the string, expand the window using map
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            end = Math.max(end, map.get(c));
            if(end == i){
                res.add(end - start + 1);
                start = i + 1;
            }
        }
        return res;
    }
}