//TC - O(n);
//SC - O(n);
//LC -621
class Solution {
    public int leastInterval(char[] tasks, int n) {
        if(tasks.length==0||tasks==null) return 0;
        
        if(n==0) return tasks.length;
        HashMap<Character,Integer> map = new HashMap<>();
        
        int maxCount=0, maxFreq=0;
        
        for(int i=0;i<tasks.length;i++){
            map.put(tasks[i],map.getOrDefault(tasks[i],0)+1);
            maxFreq = Math.max(maxFreq,map.get(tasks[i]));
        }
        
        
        for(char key : map.keySet()){
            if(map.get(key)==maxFreq) maxCount++;
        }
        
        int part = maxFreq-1;
        int empty = part*(n-(maxCount-1));
        int incompleteTask = tasks.length - (maxFreq * maxCount);
        
        int idle = Math.max(0,empty-incompleteTask);
        
        return tasks.length+idle;
        
    }
}