class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] map= new int[26];
        int max=0,count=0;

        for(char c:tasks){
            map[c-'A']++;
            max=Math.max(map[c-'A'],max);
        }
        for(char c='A';c<='Z';c++){
            if(map[c-'A']==max) count++;
        }
        int partitions=(max-1);
        int available=partitions*(n-count+1);
        int pending=tasks.length-(max*count);
        int idle= Math.max(0,available - pending);
        int res=tasks.length+idle;
        return res;
    }
}
