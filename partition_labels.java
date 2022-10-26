// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),i);
        }
        int p1 = 0;
        int p2 = map.get(s.charAt(0));
        int lastPartition =0;

        while(p1<s.length()){
            int currCh = map.get(s.charAt(p1));
            if(currCh>p2){
                p2 = currCh;
            }
            if(p1==p2){

                res.add(p1-lastPartition+1);

                lastPartition=p1+1;
            }
            p1++;
        }

        return res;
    }
}