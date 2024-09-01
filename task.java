class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxFreq = 0;
        for(int i=0;i<tasks.length;i++){
            char task = tasks[i];
            map.put(task,map.getOrDefault(task,0)+1);
            maxFreq = Math.max(maxFreq,map.get(task));   
        } 
        int maxCount = 0;
        for(char task:map.keySet()){
            if(map.get(task)==maxFreq){
                maxCount++;
            }
        }
        int partitions = maxFreq-1;
        int available = partitions*(n-(maxCount-1));
        int pending = tasks.length-(maxCount*maxFreq);
        int idle = Math.max(0,available-pending);
        return tasks.length+idle;
    }
}