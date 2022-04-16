// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// We can calculate the max idle time by (maxfreq -1) * n
// We know we have other elements too we can fill this idle time with this
// We will run the loop and subtract the freq of these from the max total idle time
// This way we will make use of the idle time and our answer would be total task + total idle time
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int [] freq = new int[26];
        for(char c: tasks){
            freq[c - 'A']++;
        }
        Arrays.sort(freq);
        int idleTime = (freq[25] - 1) * n;
        for(int i = 24; i >= 0; i--){
            idleTime -= Math.min(freq[25]-1,freq[i]);
        }
        idleTime = Math.max(0, idleTime);
        return tasks.length + idleTime;
    }
}