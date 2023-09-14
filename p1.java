// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        //Get the frequency of each task
        for(int i=0; i<tasks.length; i++){
            char c = tasks[i];
            map.put(c, map.getOrDefault(c,0)+1);
            max = Math.max(max, map.get(c));
        }

        //Get the number of tasks which occur for max number of times
        int nmax = 0;
        for(char c: map.keySet()){
            if(map.get(c) == max) nmax++;
        }

        int pending = tasks.length - (max * nmax);
        int empty = (max - 1) * (n-nmax+1);
        int idle = Math.max(0, empty-pending);
        int result = tasks.length + idle;
        return result;
    }
}