// O(n) time: n being total tasks
// O(1) space for array freq, which is fixed at 26

class Solution {
    public int leastInterval(char[] tasks, int n) {
        // frequencies of tasks
        int[] freq = new int[26];
        for (char t : tasks){
            freq[t - 'A']++;
        }
        
        Arrays.sort(freq); // sort by frequencies
        
        // max freq
        int maxFreq = freq[25];
        int idleTime = (maxFreq - 1) * n; // max idle time
        
        for (int i = freq.length - 2; i >= 0 && idleTime > 0; i--){
            idleTime -= Math.min(maxFreq - 1, freq[i]);
        }
        
        idleTime = Math.max(0, idleTime);
        
        return idleTime + tasks.length; // total slots
    }
}