package Greedy2;
//Time complexity : O(n)
//Space complexity: O(1)
public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int idle_time = 0;
        int freq_max = 0;
        int max_freq_cnt = 0;
        int[] freq = new int[26];
        for(char c : tasks){
            freq[c-'A']++;
            if(freq[c-'A'] > freq_max){
                freq_max = freq[c-'A'];
                max_freq_cnt = 1;
            } else if(freq[c-'A'] == freq_max){
                max_freq_cnt++;
            }
        }
        int partitions = freq_max-1;
        int empty = partitions*(n-(max_freq_cnt-1));
        int rem = tasks.length - freq_max*max_freq_cnt;
        int idle = Math.max(0, empty - rem);
        return tasks.length + idle;
    }
}
