// Time Complexity : O(n)
// Space Complexity :O(1)
class Solution {
    public int leastInterval(char[] tasks, int n) {
        if(tasks==null || tasks.length==0) return 0;
        HashMap<Character,Integer> map=new HashMap<>();
        int N=tasks.length;
        int max=0, maxcnt=0;
        for(int i=0;i<tasks.length;i++){
            char c=tasks[i];
            map.put(c,map.getOrDefault(c,0)+1);
            max=Math.max(max,map.get(c));
            
        }
        
        for(char task:map.keySet()){
            if(map.get(task)==max){
                maxcnt++;
            }
        }
        
        int partitions=max-1;
        int pending= N - (max*maxcnt);
        int empty= partitions * (n-(maxcnt-1));
        int idle= Math.max(0,empty-pending);
        return N+idle;
    }
}