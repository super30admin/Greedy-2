// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach : Compute a map for each character in input string and the last occurence. Iterate through string
/// again. Now for each char check if partition = curr start to last occurence of current char is possible. If yes,
/// go ahead and make the partition else extend the partition window

class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(!map.containsKey(ch)){
                map.put(ch, 0);
            }
            map.put(ch, i);
        }
        ArrayList<Integer> res = new ArrayList<>();
        int start = 0, end = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            end = Math.max(end, map.get(ch));
            System.out.println(start+" "+end+" "+ch);
            if(end == i){
                res.add(end-start+1);
                start = i+1;
            }
        }
        return res;
    }
}