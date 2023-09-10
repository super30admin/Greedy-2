// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/*
 * trying to reduce the gaps first we find the maxfreq and check how many available spots and fill them as many as possible the answer will array length + idle spots
 */


class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        int len = tasks.length;
        int maxFreq = 0;
        for(int i=0; i<len; i++){
            int index = tasks[i] - 'A';
            map[index] += 1;
            if(map[index] > maxFreq)
                maxFreq = map[index];
        }
        System.out.println("maxFreq: "+ maxFreq);
        int maxCount = 0;
        for(int i=0; i<26; i++){
            if(maxFreq == map[i]){
                maxCount++;
            }
        }
        int available = (maxFreq - 1) * (n - (maxCount - 1));
        int rem = len - (maxCount * maxFreq);
        int idle = Math.max(0, available - rem);
        return idle + len;
    }
}