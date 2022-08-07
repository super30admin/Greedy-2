//TC-O(n)
//SC-O(n)
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int maxfreq = 0;
        int maxCount = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(char t: tasks){
            int cnt = map.getOrDefault(t,0);
            cnt++;
            maxfreq = Math.max(maxfreq, cnt);
            map.put(t,cnt);
        }
        for(char key : map.keySet()){
            if(map.get(key) == maxfreq){
                maxCount++;
            }
        }
        
        int partitions = maxfreq - 1;
        int availableslots = partitions * (n-(maxCount - 1));
        int pendingTask = tasks.length - (maxfreq * maxCount);
        int idle = Math.max(0, availableslots - pendingTask);
        return tasks.length + idle;
    }
}
