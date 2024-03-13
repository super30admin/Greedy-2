class Solution {
    //TC: O(n)
    //SC: O(n)
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character,Integer> map = new HashMap<>();
        int maxFreq = 0;
        int noOfTaskMaxFreq = 0;
        for(char task : tasks){
            map.put(task,map.getOrDefault(task,0) + 1);
            maxFreq = Math.max(maxFreq,map.get(task));
        }
        for(char task : map.keySet()){
            if(map.get(task) == maxFreq){
               noOfTaskMaxFreq += 1; 
            }
        }
        int partitions = maxFreq - 1;
        int available = partitions*(n-(noOfTaskMaxFreq - 1));
        int pending = tasks.length - (maxFreq*noOfTaskMaxFreq);
        int idle = Math.max(0,available-pending);
        return tasks.length + idle;
    }
}
