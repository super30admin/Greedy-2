class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character,Integer> map= new HashMap<>();
        int maxFreq=0;
        int maxCount=0;

        for(int i=0;i<tasks.length;i++){
            char task=tasks[i];
            map.put(task,map.getOrDefault(task, 0)+1);
            maxFreq=Math.max(maxFreq,map.get(task));
        }

        for(char c: map.keySet()){
            if(map.get(c)==maxFreq){
                maxCount++;
            }
        }

        int partitions= maxFreq-1;
        int availableSlots= partitions*(n-(maxCount-1));
        int pending=tasks.length - (maxFreq*maxCount);
        int idle=Math.max(0,availableSlots-pending);
        


        return tasks.length+idle;
    }
}