// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class Solution {
    public List<Integer> partitionLabels(String s) {
        if(s == null || s.length() == 0) return new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        List<Integer> li = new ArrayList<>();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch, i);
        }
        
        int startOfWindow = 0;
        int endOfWindow = 0; // first char
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            endOfWindow = Math.max(endOfWindow, map.get(ch));
            if(i == endOfWindow){
                // record this length
                li.add(i - startOfWindow + 1);
                startOfWindow = endOfWindow + 1;
            }
        }
        return li;
    }
}