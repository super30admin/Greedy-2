// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

/*
Approach
We first create a map that keeps track of the the all occurance of an element 
the we start itterating over string, the we keep checking the map for when the i element last is
if i ==end mean all the element in the substring till i are containted in i to we make that partition

*/

class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, i);
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            end = Math.max(end, map.get(ch));
            if (end == i) {
                result.add(i - start + 1);
                start = i + 1;
            }
        }
        return result;
    }
}