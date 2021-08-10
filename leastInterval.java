// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxFreq=0;
        int maxCount=0;
        for(int i=0;i<tasks.length;i++){
            char ch= tasks[i];
            map.put(ch,map.getOrDefault(ch,0)+1);
            maxFreq=Math.max(maxFreq,map.get(ch));
        }
        for (int k: map.values()){
            if(k==maxFreq)
                maxCount++;
        }
        int len= tasks.length;//mathematical formula for finding partitions baased on max freq and then finding the empty spots, pending elements 
        int partitions=(maxFreq-1);//and then the idle state left out.
        int empty=(n-maxCount+1)*partitions;
        int pending=len-(maxFreq*maxCount);
        int idle=Math.max(0,(empty-pending));
        
        return (len+idle); 
    }
}