class Solution {
    public int leastInterval(char[] tasks, int k) {
        int n= tasks.length;
        
        if(tasks== null || n==0) return 0;
        int maxFreq=0;
        int maxCount=0;
        
        HashMap<Character,Integer>map= new HashMap<>();
        for(char task:tasks){
            if(!map.containsKey(task))
                 map.put(task,0);
            
            int cnt= map.get(task);
            cnt++;
            maxFreq= Math.max(maxFreq,cnt);
            map.put(task,cnt);
        }
        for(Character task: map.keySet()){
            if(map.get(task)==maxFreq)
                maxCount++;
        }
        
        
        
        int partition= maxFreq-1;
        int available= partition *(k-(maxCount-1));
        int pending = tasks.length - (maxFreq *maxCount);
        int empty =Math.max(0, available-pending);
        
        return tasks.length+empty;
    }
}
