// Time Complexity : O(NlogN)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int leastInterval(char[] tasks, int n) {
        if(n == 0) return tasks.length;
        char[] char_map = new char[26];
        for(char task:tasks) char_map[task-'A']++;
        Arrays.sort(char_map);
        int max_val = char_map[25]-1;
        int empty_slots = max_val * n;
        
        for(int i = 24 ; i >= 0 ; i--){
            empty_slots -= Math.min(char_map[i],max_val);
        }
        return Math.max(empty_slots,0) + tasks.length; 
    }
}
