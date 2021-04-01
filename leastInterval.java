// Time Complexity : O(n)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

// Your code here along with comments explaining your approach
class Solution {
    public int leastInterval(char[] tasks, int n) {

        Map<Character, Integer> map = new HashMap();
        int maxf=0, maxC=0;
        
        for(char c : tasks) {
            map.put(c, map.getOrDefault(c,0)+1);
            maxf = Math.max(maxf, map.get(c));
            
        }
        
        for(int v : map.values()) {
            if(v == maxf) {
                maxC++;
            }
        }
        
        int part = maxf-1;
        int empty = (n-maxC+1)*part;
        int pending = tasks.length - maxf*maxC;
        int idle = Math.max(0, empty-pending);
        
        return tasks.length+idle;
        
    }
}
