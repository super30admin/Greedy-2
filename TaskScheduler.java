class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> freq = new HashMap<>();
        int maxFreq = -1;
        int maxNum = 0;
        for(char task : tasks){
            freq.put(task, freq.getOrDefault(task, 0) + 1);
            maxFreq = Math.max(maxFreq, freq.get(task));
        }
        for(int val : freq.values()){
            if(maxFreq == val){
                maxNum++;
            }
        }

        int partitions = maxFreq - 1;
        int avalable = partitions * (n - (maxNum - 1));
        int pending  = tasks.length - maxFreq * maxNum;
        int idle = Math.max(0, avalable - pending);
        return tasks.length + idle;
    }
}
