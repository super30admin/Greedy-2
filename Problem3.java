// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
    public List<Integer> partitionLabels(String S) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<S.length();i++){
            map.put(S.charAt(i),i);
        }
        List<Integer> output= new ArrayList<>();
        int start=0; int end=0;
        for(int i=0;i<S.length();i++){
           end=Math.max(end,map.get(S.charAt(i)));//finding the max index where a particular char occurs
            if(end==i){
                output.add(end-start+1);
                start=end+1;
                end=start;
            }
        }
        return output;
    }
}