// Time Complexity : O(N)
// Space Complexity : O(1), 26 elements, constant space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class taskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        
        //fill the freq array
        for(int task: tasks){
            freq[task - 'A']++;
        }
        
        Arrays.sort(freq);
        
        int maxFreq = freq[25];
        int idle = (maxFreq - 1) * n;
        
        for (int i = freq.length - 2; i >= 0 && idle > 0; --i) {
            idle -= Math.min(maxFreq - 1, freq[i]); 
        }
        
        idle = Math.max(0, idle);

        return idle + tasks.length;
        
    }
}
