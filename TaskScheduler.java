class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character,Integer> map = new HashMap<>();
        int len = tasks.length;
        int maxFreq = 0; 
        int maxCount = 0;
        for(int i=0;i<len;i++){
            char c = tasks[i];
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for(Character c:map.keySet()){
            maxFreq = Math.max(maxFreq,map.get(c));
        }
        for(Character c:map.keySet()){
            if(map.get(c) == maxFreq){
                maxCount++;
            }
        }
        int partitions = maxFreq - 1;
        int available = partitions * (n - (maxCount - 1));
        int pending = len - maxFreq*maxCount;
        int idle = Math.max(0,available-pending);
        return len + idle;
    }
}