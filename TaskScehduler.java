class TaskScehduler {
       public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for(char c : tasks) {
            count[c - 'A']++;
        }
        Arrays.sort(count);
        int max = count[25]-1;
        int idle = max * n;
        for(int i=24; i>=0; --i) {
            idle = idle-Math.min(max, count[i]);
        }
       return idle > 0 ?  idle + tasks.length : tasks.length;
    }
}