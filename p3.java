// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        //Store the last occurence of character
        for(int i=0; i< s.length(); i++){
            char c = s.charAt(i);
            map.put(c, i);
        }

        ArrayList<Integer> result = new ArrayList<>();
        int max = 0;
        int prev = 0;
        //When we reach the last occurence of a character in the string, put that in result
        for(int i=0; i< s.length(); i++){
            char c = s.charAt(i);
            int m = map.get(c);
            max = Math.max(max, m);
            if(max == i){
                result.add(max - prev + 1);
                prev = max+1;
            }
        }

        return result;
    }
}