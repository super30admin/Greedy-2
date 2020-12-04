class Solution {//time of O(n + sorting constant) and space O(constant if length known or N)
    public int leastInterval(char[] tasks, int n) {
        //Frequency of each task;
        int[] freq = new int[26];
        for(int t: tasks){
            freq[t-'A']++;
        }
        Arrays.sort(freq);
        int maxFreq = freq[25];
        int idleTime = (maxFreq-1)*n;
        
        for(int i = freq.length - 2;i>=0 && idleTime >0 ;i--){
            idleTime -= Math.min(maxFreq - 1, freq[i]);
        }
        idleTime = Math.max(0,idleTime);
        return idleTime + tasks.length ;
    }
}