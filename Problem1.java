// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int nmax = 0;
        for(char task : tasks){
            map.put(task,map.getOrDefault(task,0)+1);
            max = Math.max(max,map.get(task));
        }
        for(char c : map.keySet() ){
            if(map.get(c) == max)
                nmax++;
        }
        int partitions = max - 1;
        int available = partitions * (n - (nmax - 1));
        int pending = tasks.length - max*nmax;
        int idle = Math.max(0,available-pending);
        return tasks.length + idle;
    }
}
