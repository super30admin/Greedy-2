
// Time Complexity : O(n) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : used the same logic Jaspinder explained in the class.

package Greedy-2;

public class Problem3 {
    public List<Integer> partitionLabels(String s) {
        List<Integer> re = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        // put last index of each character in map
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            map.put(c, i);
        }

        int start = 0, end = 0;
        for(int i =0; i< s.length(); i++){
            char c = s.charAt(i);
            end = Math.max(end,map.get(c));
            if(i == end){
                re.add(end - start + 1);
                start = i + 1;
            }
        }
        return re;
    }
}
