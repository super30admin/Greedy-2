// Time Complexity : O(nlogn) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

class Solution {
    public int leastInterval(char[] tasks, int n) {
        // Create a frequency array
        int [] freq=new int[26];
        for(int t:tasks){
            freq[t - 'A']++;
        }
        Arrays.sort(freq);
        int max=freq[25];
        int idleTime=(max-1)*n;
        for(int i=freq.length-2;i>=0 && idleTime>0;--i){
            // Subtract the minimum of the maximum frequency and the current frequency from the idle time
            idleTime=idleTime-Math.min(max-1,freq[i]);
        }
        idleTime=Math.max(0,idleTime);
        return idleTime > 0 ? idleTime + tasks.length : tasks.length;
    }
}