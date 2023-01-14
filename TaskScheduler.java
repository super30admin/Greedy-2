//time complexity is O(M+NlogN) M is length of tasks, N is length of unique tasks
//space complexity is O(K) K is 26
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char ch : tasks){
            freq[ch-'A']=freq[ch-'A']+1;
        }
        Arrays.sort(freq);
        int maxf = freq[25];
        int idle=(maxf-1)*n;
        for(int i=24;i>=0 && idle>=0;i--){
            idle=idle-Math.min(maxf-1, freq[i]);
        }
        idle = Math.max(idle,0);
        return idle+tasks.length;
    }
}
